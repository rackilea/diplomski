actionCol.setCellFactory(column -> new TableCell<Person, Void>() {

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Button details = new Button("details");
                details.setOnAction(e ->{Person person= (Person)getTableRow().getItem(); System.out.println(person.getFirstName()+", "+person.getLastName());});
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(details);
            } else {
                setGraphic(null);
            }

        }

    });