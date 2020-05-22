colQuanJour.setCellFactory( 
               new Callback<TableColumn<Log,Integer>,TableCell<Log,Integer>>(){
           @Override
           public TableCell<Log, Integer> call(TableColumn<Log, Integer> param) {
              return new TableCell<Log, Integer>(){
                  @Override
                  protected void updateItem(Integer item, boolean empty) {
                      if( ! empty){
                          // Your code...
                          setText(Char+val);
                      }else{
                          setText(null); // This will clear the text for empty rows
                      }
                  }
              };
           }
        });