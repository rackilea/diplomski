public void sorterChanged(RowSorterEvent e) {
    // The changing flag prevents an infinite loop after responding to the inital
    // sort event.
    if (!changing) {
      changing = true;

      RowSorter changedSorter = e.getSource();
      List<? extends SortKey> keys = changedSorter.getKeys();

      for (RowSorter sorter : sorters) {
        if (sorter != changedSorter) {
          // Install new sort keys, which will cause the sorter to re-sort.
          // The changing flag will prevent the mediator from reacting to this.
          sorter.setSortKeys(keys);
        }
      }
    }
  }