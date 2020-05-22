public BookingTable()
{
    super(new BorderLayout());
    _contentPanel = new JPanel();
    _contentPanel.setLayout(new BoxLayout(_contentPanel, BoxLayout.Y_AXIS));
    _scrollPane = new JScrollPane(_contentPanel);

    add(_scrollPane, BorderLayout.CENTER);
}

private void addToPanel(EntryView panel)
{
    panel.setPreferredSize(new Dimension(150, 35));
    panel.setMaximumSize(new Dimension(160, 45));
    panel.setMinimumSize((new Dimension(80, 30)));   

    _contentPanel.add(panel);
    _contentPanel.revalidate();
}