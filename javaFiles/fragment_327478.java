delbtn.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent event)
  {
    ListModel currentModel = list.getModel();
    DefaultListModel newModel = new DefaultListModel();

    for (int i = 0; i < currentModel.getSize(); i++)
    {
      CheckListItem item = (CheckListItem) currentModel.getElementAt(i);
      if (! item.isSelected())
      {
        newModel.addElement(item);
      }
    }
    list.setModel(newModel);
  }
});