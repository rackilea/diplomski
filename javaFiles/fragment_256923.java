class SimpleExample extends JFrame {

    public SimpleExample() {
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);                
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }
}

class App implements Runnable {

    public void run() {
        SimpleExample ex = new SimpleExample();
        ex.setVisible(true);
    }
}