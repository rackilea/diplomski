public class View implements Observer {
    private MyController controller;

    public View(){
         // Swing Components here
         JButton button = new JButton();
         button.addActionListener(controller);
         add(button);
    }
    // notifyObserver method implementation
}