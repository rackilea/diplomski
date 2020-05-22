import javax.swing.*;

public class SaucerDriver{

  public static void main(String[] args){
    DisplayWindow d = new DisplayWindow();
    d.setJMenuBar(new menuBar());
    SaucerPanel p = new SaucerPanel(menuBar);
    d.addPanel(p);
    d.showFrame();
  }
}