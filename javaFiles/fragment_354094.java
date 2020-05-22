JPanel zPanel = new JPanel(new MigLayout("wrap 1");
for(int i = 0; i < zones.size(); i++ )
{
    JLabel zLabel = new JLabel(zones.get(i));
    zPanel.add(zLabel);
}
grid.add(zPanel,"wrap");