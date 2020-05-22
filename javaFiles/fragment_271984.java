public static void main(String[] args)
{
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    JList list = new JList(new Object[]{ "11", "22" })
    {
        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(1000, 800);
        }
    };
    frame.getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);

    frame.setVisible(true);
}