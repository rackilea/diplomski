public static void main(String[] args)
{
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    JTable table = new JTable(new Object[][]{{50, 50},{50, 50}} , new Object[]{"1", "2"});
    table.setDefaultRenderer(Object.class, new ProgressBarRender());
    frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

    frame.setVisible(true);
}

public static class ProgressBarRender extends DefaultTableCellRenderer
{
    private final JPanel panel;
    private final JProgressBar b;

    public ProgressBarRender()
    {
        super();
        setOpaque(true);
        b = new JProgressBar();

        b.setStringPainted(true);
        b.setMinimum(0);
        b.setMaximum(100);

        b.setBorderPainted(true);
        b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        //b.setPreferredSize(new Dimension(1,1));
        b.setOpaque(true);

        panel = new JPanel(new BorderLayout());
        panel.add(b, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        //TODO
        //b.setForeground(Color.magenta);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        Integer i = (Integer)value;
        b.setValue(i);
        if (isSelected)
        {
            b.setBackground(Color.BLUE);
            panel.setBackground(Color.DARK_GRAY);
        }
        else
        {
            b.setBackground(Color.GREEN);
            panel.setBackground(Color.LIGHT_GRAY);
        }
        return panel;
    }
}