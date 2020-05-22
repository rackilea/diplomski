int i = 0;
    for (Field field : entityClass.getDeclaredFields())
    {
        if (!isFieldHidden(field))
        {
            if (isFieldEntityType(field))
            {
                ComboBox searchField = new ComboBox();
                searchField.setPromptText("Recherche");
                searchField.setMaxWidth(Double.MAX_VALUE);
                searchField.getSelectionModel().selectedItemProperty().addListener((observable) -> 
                {
                    showEntities();
                });

                TFHService service = serviceMap.get(field.getType());
                ObservableList items = FXCollections.observableArrayList(service.findAll());
                items.add(0, service.createDummy());
                searchField.setItems(items);

                searchFields.put(i, searchField);
            }
            else
            {
                TextField searchField = new TextField();
                searchField.setPromptText("Recherche");
                searchField.setAlignment(Pos.CENTER);
                searchField.setOnKeyReleased((event) -> 
                {
                    showEntities();
                });

                searchFields.put(i, searchField);
            }

            i++;
        }
    }