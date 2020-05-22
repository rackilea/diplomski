package myPackage;

import java.awt.BorderLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

@SuppressWarnings("serial")
public class PenguinApplet extends JApplet {
   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               createAndShowGui();
            }
         });
      } catch (InterruptedException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
   }

   public void createAndShowGui() {
      String penguinImgResource = "images/MyImage.jpg";
      try {
         Penguin penguinPanel = new Penguin(penguinImgResource );
         getContentPane().add(penguinPanel, BorderLayout.CENTER);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}