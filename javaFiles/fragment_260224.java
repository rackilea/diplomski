import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ItemListener;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.geom.*;
import java.util.*;
public class optionsDineIn extends JPanel {
   JLabel lab1 = new JLabel("Welcome");
   boolean lab1state = false;
   JPanel p = new JPanel();

    public void construct() {
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    if(lab1state){
                        lab1.setText("Welcome");
                    }else{
                        lab1.setText("Register");
                    }
                    lab1state = !lab1state;
                }
            }, 
            2000,
            2000
        );
    }
    p.add(lab1);
   }