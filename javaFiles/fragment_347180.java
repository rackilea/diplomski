import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

class Demo{
    public static void main(String[]args){
        SwingUtilities.invokeLater(()->{
            JFrame frame=new JFrame("Right-Left");
            JTextPane box=new JTextPane();
            frame.getContentPane().add(box);
            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
            box.setParagraphAttributes(attr, true);
            frame.setSize(300,200);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }
}