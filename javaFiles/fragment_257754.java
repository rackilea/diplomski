MATIERE.setCellValueFactory(new Callback<CellDataFeatures<Enseignant,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Enseignant, String> param) {
                    return new SimpleStringProperty(param.getValue().getMatiere().getIntitule());
                }
            });