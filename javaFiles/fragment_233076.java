import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;


// A class encapsulating an image and a x-coordinate (a "model")
class MovableImage {
    Image i = new ImageIcon("duke.png").getImage();
    private int x = 0;

    // Observers that are interested in movements.
    List<ChangeListener> listeners = new ArrayList<ChangeListener>();

    public void addListener(ChangeListener cl) {
        listeners.add(cl);
    }

    public int getX() {
        return x;
    }

    public void incrementX() {
        x += 10;

        // Notify those interested.
        for (ChangeListener cl : listeners)
            cl.stateChanged(null);
    }
}