private JScrollPane textPanel() {
    String header[] = {"Date/Time","Log Entry"};

    String data[][] = 
    {       
            {"18-08-2014 - 16:21","Something"},
            {"18-08-2014 - 16:21","Something"},
            {"18-08-2014 - 16:21","Something"}  
    };

    JTable tPanel = new JTable(data,header);

    tPanel.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 14));

    tPanel.setGridColor(Color.BLACK);
    tPanel.setForeground(Color.WHITE);
    tPanel.setBackground(Color.BLACK);
    tPanel.getTableHeader().setResizingAllowed(false);
    tPanel.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

    TableColumnAdjuster tca = new TableColumnAdjuster(tPanel);
    tca.adjustColumns();

    JScrollPane sPanel;

    sPanel = new JScrollPane(tPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    sPanel.getViewport().setBackground(Color.BLACK);

    return sPanel;