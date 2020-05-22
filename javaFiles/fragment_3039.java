//Name your table view in your FXML file and wire it like this.
@FXML
private TableView tableview;

//Then in your method where you process the data you can add columns dynamically....
        /**********************************
         * TABLE COLUMN ADDED DYNAMICALLY *
         **********************************/
        for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;                
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });

            tableview.getColumns().addAll(col); 
            System.out.println("Column ["+i+"] ");
        }

//Etc....