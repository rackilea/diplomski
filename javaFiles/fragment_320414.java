public class DatasetOutline extends Outline {

  public DatasetOutline(DatasetTreeModel mdl) {
    setRenderDataProvider(new DatasetRenderProvider());
    setRootVisible(false);
    setShowGrid(false);
    setIntercellSpacing(new Dimension(0, 0));
    setModel(DefaultOutlineModel.createOutlineModel(mdl, new DatasetOutlineRowModel(), true,
        "Dataset"));
    getColumnModel().getColumn(1).setCellRenderer(new ExclusiveBooleanRenderer());
    getColumnModel().getColumn(1).setCellEditor(new ExclusiveBooleanEditor());
    // [snip]
    getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }

  // Update the entire column of the conditional boolean if one is changed
  @Override
  public void editingStopped(ChangeEvent e) {
    super.editingStopped(e);
    if (e.getSource() instanceof ExclusiveBooleanEditor) {
      tableChanged(new TableModelEvent(getModel(), 0, getRowCount(), 1, TableModelEvent.UPDATE));
    }
  }
}