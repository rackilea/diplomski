concatColumns.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(CellDataFeatures<ObservableList, String> p) {
            final ObservableList row = p.getValue();

            List<Observable> dependencies = new ArrayList<>();
            for (Object value : row) {
                if (value instanceof Observable) {
                    dependencies.add((Observable)value);
                }
            }
            dependencies.add(row);

            StringExpression se = Bindings.createStringBinding(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < row.size(); i++) {
                        //Check for Property objects and append the value
                        if (row.get(i) instanceof Property) {
                            sb.append(((Property)row.get(i)).getValue());
                        }
                        else {
                            sb.append(row.get(i));
                        }

                        if (i+1 < row.size()) {
                            sb.append(", ");
                        }
                    }
                    return sb.toString();
                }
            }, dependencies.toArray(new Observable[dependencies.size()]));
            return se;
        }
    });