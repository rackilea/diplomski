TableView<A> table;

TableColumn<A, a1> column_a1 = new TableColumn<A, a1>("a1 property");
column_a1.setCellValueFactory(new PropertyValueFactory<A, a1>("a1"));

TableColumn<A, b1> column_b1 = new TableColumn<A, b1>("b1 property");

column_b1.setCellValueFactory(new Callback<CellDataFeatures<A, b1>, ObservableValue<b1>>() {
    public ObservableValue<b1> call(CellDataFeatures<A, b1> p) {
        if(p.getValue() instanceof B){
            return new ObservableValue<B.b1>() {
                @Override
                public void removeListener(InvalidationListener arg0) {}
                @Override
                public void addListener(InvalidationListener arg0) {}
                @Override
                public void removeListener(ChangeListener<? super b1> listener) {}

                @Override
                public b1 getValue() {
                    return ((B)p.getValue()).getSameNameOfProperty();
                }

                @Override
                public void addListener(ChangeListener<? super b1> listener) {}
                };
            }
        return null;
        }
    });

TableColumn<A, c1> column_c1 = new TableColumn<A, c1>("c1 property");

column_c1.setCellValueFactory(new Callback<CellDataFeatures<A, c1>, ObservableValue<c1>>() {
    public ObservableValue<c1> call(CellDataFeatures<A, c1> p) {
        if(p.getValue() instanceof C){
            return new ObservableValue<C.c1>() {
                @Override
                public void removeListener(InvalidationListener arg0) {}
                @Override
                public void addListener(InvalidationListener arg0) {}
                @Override
                public void removeListener(ChangeListener<? super c1> listener) {}

                @Override
                public c1 getValue() {
                    return ((C)p.getValue()).getSameNameOfProperty();
                }

                @Override
                public void addListener(ChangeListener<? super c1> listener) {}
            };
        }
        return null;
        }
   });
table.getColumns().add((TableColumn<A, a1>) column_a1);
table.getColumns().add((TableColumn<A, b1>) column_b1);
table.getColumns().add((TableColumn<A, c1>) column_c1);

table.setItems((ObservableList<A>) list);