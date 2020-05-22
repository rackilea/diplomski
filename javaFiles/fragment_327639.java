public class Grid {
    private JFrame frame = new JFrame();
    private JButton[][] grid; // Has to be a field of the object. static would make it to an field of the class

    public Grid (int w, int l) {
        frame.setLayout(new GridLayout(w, l));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        createGrid (w, l);
    }

    private void createGrid (int w, int l) {
        // Your above implementation
    }

    public void stepInSimulation () {
        // Your algorithm, you want to implement
    }

    public JButton[][] getGrid () {
        return grid;
    }

    public static void main (String[] args) {
        Grid grid = new Grid(2,2);
        grid.getGrid ()[0][1]; // Access a value
        grid.stepInSimulation (); // Do a step, call it in while loop, to do multiple steps
    }
}