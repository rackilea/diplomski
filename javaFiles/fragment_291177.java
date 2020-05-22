public class InternalFrameEventDemo implements InternalFrameListener{
    JInternalFrame frame;
    public InternalFrameEventDemo() {
        frame = new JInternalFrame("Event Generator",
                                                      true,  //resizable
                                                      true,  //closable
                                                      true,  //maximizable
                                                      true); //iconifiable
        //so that you can decide whether to close it or not
        frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        frame.addInternalFrameListener(this);
    }
    public void internalFrameClosing(InternalFrameEvent e) {
        //YOUR CODE HERE
        int option = JOptionPane.showConfirmDialog(null, "Really Close?", "Exit", JOptionPane.YES_NO_OPTION);  
        if (option == JOptionPane.YES_OPTION){
            //call dispose to really close it
            dispose();  
        }  
    }
    public void internalFrameClosed(InternalFrameEvent e) {

    }
    public void internalFrameOpened(InternalFrameEvent e) {

    }
    public void internalFrameIconified(InternalFrameEvent e) {

    }
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }
    public void internalFrameActivated(InternalFrameEvent e) {

    }
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    public static void main(String[] args) {
        new InternalFrameEventDemo();
    }
}