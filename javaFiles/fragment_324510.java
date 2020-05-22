public class Iceberg extends JPanel implements ActionListener, KeyListener {

    private List<GameListener> listeners = new ArrayList<>(25);


    public void addGameListener(GameListener listener) {
        listeners.add(listener);
    }

    public void removeGameListener(GameListener listener) {
        listeners.remove(listener);         
    }