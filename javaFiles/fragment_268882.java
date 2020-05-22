public static void main(String args[]) {

    JFrame f = new JFrame("JDesktopPane Sample");

    JTable jt = new JTable();

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container content = f.getContentPane();

    JLayeredPane desktop = new JDesktopPane();

    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3"},
        { "Row2-Column1", "Row2-Column2", "Row2-Column3"} };

    Object columnNames[] = { "Column One", "Column Two", "Column Three"};

    JTable table = new JTable(rowData, columnNames);

    desktop.setOpaque(false);
    desktop.add(createLayer2(table),JLayeredPane.POPUP_LAYER);
    content.add(desktop, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);
}



public static JInternalFrame createLayer2(JTable n) {

    return new SelfInternalFrame2(n);

}


static class SelfInternalFrame2 extends JInternalFrame {

    public SelfInternalFrame2(JTable n) {

        getContentPane().add(n, BorderLayout.CENTER);

        setBounds(50, 50, 100, 100);

        setResizable(true);

        setClosable(true);

        setMaximizable(true);

        setIconifiable(true);

        setVisible(true);

    }

}