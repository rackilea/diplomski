if (adapter.getComponent() instanceof JTable) {
      JTable table = (JTable) adapter.getComponent();
      TableModel model = table.getModel();
      if (model instanceof MyModel) {
          int modelRow = adapter.convertRowIndexToModel(adapter.row);
          MyObject object = ((MyModel).getRowObjectAt(modelRow));
          ... // check the object
      }
  }