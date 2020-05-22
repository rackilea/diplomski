package stack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BackwardsDots extends JFrame{

    JLabel label = new JLabel(){
                        @Override
                        public Dimension getPreferredSize(){
                            return new Dimension(200,100);
                        }
                    };
    String text = "This is a design requirement and not my whim";
    FontMetrics fm;
    Font theFontBeingUsed;
//--------------------------------------------------------------------------------  
    public BackwardsDots(){
        getContentPane().add(label);
        pack();

        theFontBeingUsed = new Font("Ubuntu",Font.BOLD,14);
        fm = Toolkit.getDefaultToolkit().getFontMetrics(theFontBeingUsed);



        label.setText(trimmedStringCalculator(text));
        label.setToolTipText(text);
        label.setBorder(BorderFactory.createDashedBorder(Color.RED));
        label.addComponentListener(new ComponentListener(){

            @Override
            public void componentHidden(ComponentEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void componentMoved(ComponentEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void componentResized(ComponentEvent arg0) {
                label.setText(trimmedStringCalculator(text));
            }

            @Override
            public void componentShown(ComponentEvent arg0) {
                // TODO Auto-generated method stub

            }

        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//--------------------------------------------------------------------------------
    private String trimmedStringCalculator(String inputText){
        String ellipses = "...";
        String textToBeDisplayed = "";

        int widthOfJLabel = label.getWidth();

        for(int i = text.length()-1; i >= 0; i--){
            if(fm.stringWidth(ellipses + textToBeDisplayed) <= widthOfJLabel){
                textToBeDisplayed = text.charAt(i) + textToBeDisplayed;
            }
        }

        String finalText;
        if(textToBeDisplayed.equals(inputText)){
            finalText = inputText;
        }else{
            finalText = ellipses.concat(textToBeDisplayed);
        }

        return finalText;
    }
//--------------------------------------------------------------------------------  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new BackwardsDots();
            }
        });
    }
}