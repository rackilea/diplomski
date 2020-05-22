JDesktopPane desktop;

public ManagerInterface() {
    showEmployees = new ShowEmployees();
    desktop = new JDesktopPane();
    desktop.add(showEmployees);

    frame = new JFrame("MagagerInterface");
    frame.setContentPane(desktop);
    ....
}