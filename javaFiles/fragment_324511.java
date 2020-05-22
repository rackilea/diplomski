public class Iceberg extends JPanel implements ActionListener, KeyListener {
    //...       
    protected void fireCompleted() {
        for (GameListener listener : listeners) {
            listener.completed(this);
        }
    }