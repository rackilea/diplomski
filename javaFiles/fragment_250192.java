public void createPage1()
{
    panel = new JPanel();
    panel.setLayout( new BorderLayout() );

    ////////////////////////
    JScrollPane scrollPanel = new JScrollPane();
    scrollPanel.setViewportView(new JLabel("hellossssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"));
    scrollPanel.setPreferredSize(new Dimension(400,400));
    ///////////////////////

    panel.add(scrollPanel,BorderLayout.CENTER);
}