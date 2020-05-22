col.setLabelProvider(new ColumnLabelProvider() {
          @Override
          public void update(final ViewerCell cell) {
               cell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GREEN)); 
               final int index = cell.getColumnIndex();
               final TableItem item = (TableItem) cell.getItem();
               Display.getCurrent().timerExec(1000, new Runnable() {
                    public void run() {
                      //make sure table is not disposed
                      item.setBackground(index, Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
                    }
               });
          }
        });