package com.amish.whatever;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

public class TearAwayTab extends JWindow {
    MousePoller mousePoller = new MousePoller();
    public TearAwayTab() {
        this.add(new JLabel("FLONT"));
        this.pack();
        new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new EasyDropTarget(), true);
        this.setVisible(false);
    }

    private void center(Point location)
    {
        Point center = new Point();
        center.setLocation(location.x-this.getWidth()/2, location.y-this.getHeight()/2);
        TearAwayTab.this.setLocation(center);
    }

    public void attach(Point location)
    {
        center(location);
        mousePoller.start();
        this.setVisible(true);
    }

    public void detach()
    {
        mousePoller.stop();
        this.setVisible(false);
    }

    private int DELAY = 10;
    private class MousePoller extends Timer{
        public MousePoller(){
            super(DELAY, new ActionListener() {
                private Point lastPoint = MouseInfo.getPointerInfo().getLocation();
                @Override
                public void actionPerformed(ActionEvent e) {
                    Point point = MouseInfo.getPointerInfo().getLocation();

                    if (!point.equals(lastPoint)) {
                        center(point);
                    }

                    lastPoint = point;
                }
            });
        }
    }

    private class EasyDropTarget implements DropTargetListener
    {

        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
            dtde.acceptDrag(dtde.getDropAction());
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {}

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {}

        @Override
        public void dragExit(DropTargetEvent dte) {}

        @Override
        public void drop(DropTargetDropEvent dtde) {
            dtde.dropComplete(true);
            detach();
            System.out.println("DROP Intercepted");
        }
    }
}