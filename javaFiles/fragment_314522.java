public static void main(String[] args)
{
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    final JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JPanel(), new JPanel());

    frame.getContentPane().add(panel, BorderLayout.CENTER);

    final JPanel glassPane = new JPanel(){
        @Override
        public boolean contains(int x, int y)
        {
            Component[] components = getComponents();
            for(int i = 0; i < components.length; i++)
            {
                Component component = components[i];
                Point containerPoint = SwingUtilities.convertPoint(
                    this,
                    x, y,
                    component);
                if(component.contains(containerPoint))
                {
                    return true;
                }
            }
            return false;
        }
    };
    glassPane.setOpaque(false);
    JButton button = new JButton("haha");
    button.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("haha");
        }
    });
    glassPane.add(button);
    glassPane.setBorder(BorderFactory.createLineBorder(Color.red));
    frame.setGlassPane(glassPane);

    //try to comment out this line to see the difference.
    glassPane.setVisible(true);

    frame.setVisible(true);
}