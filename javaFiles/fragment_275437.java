public class Test extends JFrame
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                JFrame.setDefaultLookAndFeelDecorated(true);  
                new Test();
            }
        });
    }

    public Test()
    {
        setBounds(100,100,380,400);
        setTitle("بوابة العالم");
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"التاريخ","الفلسفة","الفلك"});
        comboBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        comboBox.setPreferredSize(new Dimension(300,comboBox.getPreferredSize().height));
        comboBox.setRenderer(new CellRenderer());
        add(comboBox);

        JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(300, 300));
        textPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JScrollPane scroll = new JScrollPane(textPane);
        scroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(scroll);

        setVisible(true);
    }

}

class CellRenderer implements ListCellRenderer<String>
{
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus)
    {
        JLabel label = new JLabel(value);
        label.setOpaque(true);
        label.setFocusable(true);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        if (isSelected) {
            label.setBackground(list.getSelectionBackground());
            label.setForeground(list.getSelectionForeground());
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }
        return label;
    }
}