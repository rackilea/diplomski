JList
...
setCellRenderer(new MyCellRenderer());
...
class MyCellRenderer extends DefaultListCellRenderer
{
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
  {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    Color bg = <calculated color based on value>;
    setBackground(bg);
    setOpaque(true); // otherwise, it's transparent
    return this;  // DefaultListCellRenderer derived from JLabel, DefaultListCellRenderer.getListCellRendererComponent returns this as well.
  }
}