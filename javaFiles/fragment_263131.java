int totalSavingValue=0;
       for (int i= 0;i<tblDispatchHistory.getItems().size();i++){
            total = total+Integer.valueOf(String.valueOf(contentTable.getColumns().get(7).getCellObservableValue(i).getValue()));
           }
 System.out.println(totalSavingValue);
 tSL.setText(totalSavingValue);