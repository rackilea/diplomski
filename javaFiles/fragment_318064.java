package objects;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JLayeredPane;

public class BoardPane extends JLayeredPane {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private boolean dragging;
    private Tile draggingTile;
    private BoardSpace currentSpace;
    private BoardSpace startingSpace;
    private Component selectedObject;
    Component [] panelObjects;
    private BoardPane dragLayer;
    private Point dragPoint;
    private int dragWidth;
    private int dragHeight;

    public BoardPane() {
        this.dragging = false;
        this.draggingTile = null;
        this.currentSpace = null;
        this.startingSpace = null;
        this.selectedObject = null;
        this.panelObjects = null;
        this.dragLayer = null;
        this.dragPoint = null;
        this.dragWidth = 51/2;
        this.dragHeight = 51/2;
    }

    public static void resetPane(BoardPane board) {
        board.dragging = false;
        board.draggingTile = null;
        board.currentSpace = null;
        board.startingSpace = null;
        board.selectedObject = null;
        board.panelObjects = null;
        board.dragLayer = null;
        board.dragPoint = null;
    }

    public static Boolean getDragStatus(BoardPane board) {
        return board.dragging;
    }

    public static void setDragStatus(BoardPane board, Boolean status) {
        board.dragging = status;
    }

    public static Tile getDragTile(BoardPane board) {
        return board.draggingTile;
    }

    public static void setDragTile(BoardPane board, Tile t) {
        board.draggingTile = t;
    }

    public static BoardSpace getCurrentSpace(BoardPane board) {
        return board.currentSpace;
    }

    public static void setCurrentSpace(BoardPane board, BoardSpace bs) {
        board.currentSpace = bs;
    }

    public static BoardSpace getStartingSpace(BoardPane board) {
        return board.startingSpace;
    }

    public static void setStartingSpace(BoardPane board, BoardSpace bs) {
        board.startingSpace = bs;
    }

    public static Component getSelectedObj(BoardPane board) {
        return board.selectedObject;
    }

    public static void setSelectedObj(BoardPane board, Component obj) {
        board.selectedObject = obj;
    }

    public static Component [] getPanelObjects(BoardPane board) {
        return board.panelObjects;
    }

    public static BoardPane getDragLayer(BoardPane board) {
        return board.dragLayer;
    }

    public static void setDragLayer(BoardPane board) {
        board.dragLayer = board;
    }

    public static void setPanelObjects(BoardPane board, Component [] obj) {
        board.panelObjects = obj;
    }

    public static Point getDragPoint (BoardPane board) {
        return board.dragPoint;
    }

    public static void setDragPoint(BoardPane board, Point p) {
        board.dragPoint = p;
    }

    public static int getDragWidth(BoardPane board) {
        return board.dragWidth;
    }

    public static int getDragHeight(BoardPane board) {
        return board.dragHeight;
    }

}