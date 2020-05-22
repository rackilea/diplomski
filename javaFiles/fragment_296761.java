customerName.textProperty().addListener((observable, oldValue, newValue) -> {
                if(treeMapCustomerName.containsKey(newValue)){
                    customerId.setText(treeMapCustomerName.get(newValue));
                }
            });

            customerId.textProperty().addListener((observable, oldValue, newValue) -> {
                if(treeMapCustomerId.containsKey(newValue)){
                    customerName.setText(treeMapCustomerId.get(newValue));
                }
            });