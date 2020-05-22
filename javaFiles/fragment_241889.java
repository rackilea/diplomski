ImageIcon icon=new ImageIcon(getClass().getResource("exit.png"));
String[] columns={"Page No","Chapter","Image"};
Object[][] rows={{1,4,icon},{2,7,icon}};

DefaultTableModel model = new DefaultTableModel(rows, columns) {
    @Override
    public Class<?> getColumnClass(int column) {
        switch(column) {
            case 0:
            case 1: return Integer.class;
            case 2: return ImageIcon.class;
            default: return Object.class;
        }
    }
};
JTable table = new JTable(model);