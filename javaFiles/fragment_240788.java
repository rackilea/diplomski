public class ManagerInterface {
    private Frame frame;
    private ShowEmployees showEmployee;

    public ManagerInterface() {
        showEmployees = new ShowEmployees();

        frame = new JFrame("MagagerInterface");
        frame.add(new ShowEmployees());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativTo(null);
        frame.setVisible(true);
    }
}

public class ShowEmployees extends JInternalFrame {
    public ShowEmployees() {

    }
}