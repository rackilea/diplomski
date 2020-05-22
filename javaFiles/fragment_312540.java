public class MyClass extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            // Double click
        } else {
           // Simple click
        }
    }     
}