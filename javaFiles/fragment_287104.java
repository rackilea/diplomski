private final List<TableModelListener> listeners = new LinkedList<TableModelListener>();

   public void addTableModelListener (TableModelListener l) {
          listeners.add(l);
   }

   public void removeTableModelListener (TableModelListener l) {
          listeners.remove(l);
   }

   public void updateColumn (int column) {
          TableModelEvent evt = new TableModelEvent(this, 0, Math.max(0, getRowCount() - 1), column);
          for (TableModelListener listener : listeners) {
                 listener.tableChanged(evt);
          }
   }