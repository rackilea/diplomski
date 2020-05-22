/**
 * 
 * This program prints the given text in the font inputted by the user in JTextField
 */

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class FontSampler extends GraphicsProgram implements KeyListener{
private static final String TEST_STRING = "This is a test";
private static final double LEFT_MARGIN = 3;
private static final int MAX_FONT_NAME = 10;

public void init(){
    initPanel();    //init panel
    addJFontTextField();    //adds fontField to enter the font type
    addGLabel();    //adds default label to GCanvas
    lastY = 0;  //default y offset for post-processed label
    add(panel); //adds panel to canvas
}

/**
 * initialises panel 
 */
private void initPanel() {
    panel = new JPanel();
    panel.setLayout(new BorderLayout());

}

/**
 * Adds a text field to enter the required font
 */
private void addJFontTextField() {
    fontField = new JTextField( MAX_FONT_NAME);//added to see if Jtextfiled is responding
    panel.add(fontField, BorderLayout.SOUTH);
    fontField.addKeyListener(this); //adds key listener
}

/**
 * Adds the test label to canvas
 */
private void addGLabel() {
    lastLabel = new GLabel(TEST_STRING);
    add(lastLabel, 20, 20);

}

    /**
     * Called when any key is pressed
     */
public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_ENTER){//check for enter key pressed
        GLabel label = new GLabel(TEST_STRING);
        label.setFont(lastLabel.getFont()); 
        label.setFont(fontField.getText());
        addGlabel(label);
        lastLabel = label;
    }
}

/**
 *adds a Glabel on the next line adjusting for heights
 * @param label
 */
private void addGlabel(GLabel label) {
    lastY += label.getHeight();
    lastY += lastLabel.getDescent() - label.getDescent();
    add(label, LEFT_MARGIN, lastY);
}

/**
 * JTextField to enter font
 */
private JTextField fontField;
/**
 * GLabel which is being worked on
 */
private GLabel lastLabel;
/**
 * 
 */
private double lastY;

private JPanel panel;

}