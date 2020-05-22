/*
 * RubberBandSelect.java
 *
 * Created on August 18, 2005, 9:11 AM
 * By Matthew Stemen/Wintermute Studios for util like use
 *
 */
package com.ges.util;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**
 *
 * @author mstemen
 */
public class RubberBandSelect extends Component {

    /** Creates a new instance of RubberBandSelect */
    private Point startPoint = null;
    private Point endPoint = null;
    private Graphics hostGraphics = null;
    private Component hostComponent = null;
    private Color bandColor = Color.ORANGE.darker().darker();
    private boolean started = false;
    private boolean eraseSomething = false;
    private int startX, endX, startY, endY = 0;
    private Rectangle boundingBox;
    private StringBuilder QuadrantMessage = null;
    private HashSet<RubberBandListener> listeners =
        new HashSet<RubberBandListener>();
    private int width = 0;
    private int height = 0;

    public RubberBandSelect(Component c) {
        hostComponent = c;
        hostGraphics = c.getGraphics();
    }

    public void addListener(RubberBandListener l) {
        listeners.add(l);
    }

    public void paint(Graphics g) {
        draw();
    }

    public void erase() {
        if (eraseSomething) {
//            hostComponent.repaint();
            draw();
            eraseSomething = false;
        }
    }

    private void draw() {
        hostGraphics = hostComponent.getGraphics();
        if (hostGraphics != null) {
            try {
                /// hostGraphics.setXORMode( hostComponent.getBackground() );
                erase();
                drawRubberBand();
                eraseSomething = false;
            } finally {
//                hostGraphics.dispose();
            }
        }
    }

    private void drawRubberBand() {
        if (!started) {
            return;
        }

        hostGraphics = hostComponent.getGraphics();
        if (hostGraphics == null) {
            return;
        }

        if (startPoint == null || endPoint == null) {
            return;
        }

        hostGraphics.setColor(bandColor);

        if (endX > startX && endY > startY) {
            boundingBox = new Rectangle(startX, startY, endX - startX, endY - startY);
            hostGraphics.drawRect(startX, startY, endX - startX, endY - startY);

            QuadrantMessage = new StringBuilder("Drawing in Q - IV X1=");
            width = endX - startX;
            height = endY - startY;
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
        } else if (endX < startX && endY < startY) {
            boundingBox = new Rectangle(endX, endY, startX - endX, startY - endY);
            hostGraphics.drawRect(endX, endY, startX - endX, startY - endY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - II X1=");
            width = startX - endX;
            height = startY - endY;

        } else if (endX > startX && endY < startY) {
            boundingBox = new Rectangle(startX, endY, endX - startX, startY - endY);
            hostGraphics.drawRect(startX, endY, endX - startX, startY - endY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - I X1=");
            width = endX - startX;
            height = startY - endY;
        } else if (endX < startX && endY > startY) {
            boundingBox = new Rectangle(endX, startY, startX - endX, endY - startY);
            hostGraphics.drawRect(endX, startY, startX - endX, endY - startY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - III X1=");
            width = startX - endX;
            height = endY - startY;
        }


    }

    public void assignToCompoent(Component c) {
        this.hostComponent = c;
        hostGraphics = c.getGraphics();
    }

    public void update(Graphics g) {
        drawRubberBand();
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
        startX = (int) startPoint.getX();
        startY = (int) startPoint.getY();
        QuadrantMessage = new StringBuilder();
        // UDTMgr.getMgr().sendStatusMessage( "RubberBandSelect--Started:  point is: X=" + startX + " Y=" + startY );
        // drawRubberBand();
        // started = true;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {

        this.endPoint = endPoint;
        clear();
        endX = (int) endPoint.getX();
        endY = (int) endPoint.getY();
        // UDTMgr.getMgr().sendStatusMessage( "RubberBandSelect--Streching: points are: X=" + startX + " Y=" + startY + " Ending Point is: X=" + endX + " Y="+ endY );

        draw();
        notifyListeners();
        started = true;
    }

    public Color getBandColor() {
        return bandColor;
    }

    public void setBandColor(Color bandColor) {
        this.bandColor = bandColor;
    }

    public void setForeground(Color color) {
        this.bandColor = color;

    }

    private void clear() {
        hostGraphics = hostComponent.getGraphics();
        if (hostGraphics == null) {
            return;
        }
        // hostGraphics.setXORMode( hostComponent.getBackground() );
        try {
            // hostGraphics.setXORMode( hostComponent.getBackground() );
            drawRubberBand();
        } finally {
//            hostGraphics.dispose();
        }
    }

    public void breakBand() {
        startPoint = null;
        endPoint = null;
        started = false;
        boundingBox = new Rectangle(0, 0, 0, 0);
        if (hostGraphics != null) {
            hostGraphics.dispose();
        }
        clear();
        hostComponent.repaint();
        // UDTMgr.getMgr().sendStatusMessage( "RubberBandSelect-- Broke band, click to restart" );
    }

    public boolean isStarted() {
        return started;
    }

    public void notifyListeners() {
        Iterator<RubberBandListener> it = listeners.iterator();

        while (it.hasNext()) {
            it.next().notifyBounds(boundingBox);
        }
    }

    public void redraw(Graphics g) {
        if (startPoint == null || endPoint == null) {
            return;
        }

        g.setColor(bandColor);
//        hostGraphics.setPaintMode();
        // hostComponent.repaint();
        // four way case state to determine what quadrant to draw in
        if (endX > startX && endY > startY) {
            boundingBox = new Rectangle(startX, startY, endX - startX, endY - startY);
            g.drawRect(startX, startY, endX - startX, endY - startY);

            QuadrantMessage = new StringBuilder("Drawing in Q - IV X1=");
            width = endX - startX;
            height = endY - startY;
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
        } else if (endX < startX && endY < startY) {
            boundingBox = new Rectangle(endX, endY, startX - endX, startY - endY);
            g.drawRect(endX, endY, startX - endX, startY - endY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - II X1=");
            width = startX - endX;
            height = startY - endY;

        } else if (endX > startX && endY < startY) {
            boundingBox = new Rectangle(startX, endY, endX - startX, startY - endY);
            g.drawRect(startX, endY, endX - startX, startY - endY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - I X1=");
            width = endX - startX;
            height = startY - endY;
        } else if (endX < startX && endY > startY) {
            boundingBox = new Rectangle(endX, startY, startX - endX, endY - startY);
            g.drawRect(endX, startY, startX - endX, endY - startY);
            //UDTMgr.getMgr().sendStatusMessage( "Drawing Rect: " + "(X1=" + startX + ",Y1=" + startY + ") (X2=" + endX + ",Y2=" + endY + ")"  );
            QuadrantMessage = new StringBuilder("Drawing in Q - III X1=");
            width = startX - endX;
            height = endY - startY;
        }
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}