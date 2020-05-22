column = new ColumnConfig();
        column.setRenderer(new GridCellRenderer() {
            @Override
            public Object render(ModelData model, String property, ColumnData config,                      int rowIndex, int colIndex, ListStore store, Grid grid) {

                final int row = store.indexOf((PropertyItem) model);

                Button b = new Button("remove", new SelectionListener<ButtonEvent>() {
                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        Window.alert("row index= " + row);
                        remove(row, customerId);
                    }
                });

                b.setIconStyle("/gxt/images/gxt/icons/delete.png");
                return b;
            }
        });