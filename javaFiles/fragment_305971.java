public void handleAddSURVClick(ActionEvent actionEvent) {
        survName = name.getText();
        max = maxp.getText();
        min = minp.getText();
        surveillance=new ArrayList<>(); 
        surveillance.add(survName);
        surveillance.add(monitoredObject);
        surveillance.add(monitoredProperty);
        surveillance.add(max);
        surveillance.add(min);
        // Add surveillance to the vector
        survs.add(k, surveillance);k++;
        //Surv initialisation
        survName = ""; name.clear();
        max = ""; maxp.clear();
        min = ""; minp.clear();
        monitoredObject = "";
        monitoredProperty = "";

    }