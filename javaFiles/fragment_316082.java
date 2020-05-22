public class MouseAdapterMod extends MouseAdapter {

   // usually better off with mousePressed rather than clicked
   public void mousePressed(MouseEvent e) {
       ButtonPanel btnPanel = (ButtonPanel)e.getSource();
       btnPanel.setButtonText();
   }
}