nameCol.setCellFactory(column -> {
            return new TableCell<Person, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {

                        setText(null);
                        setStyle("");

                    } else {

                        Text text1 = new Text( item.substring(0, item.indexOf(" ")));
                        text1.setFill(Color.RED);
                        text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 12));
                        Text text2 = new Text( item.substring(item.indexOf(" ")));
                        text2.setFill(Color.BLUE);
                        text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
                        TextFlow textFlow = new TextFlow(text1, text2);

                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        setGraphic(textFlow);
                        setPrefHeight(20);

                    }
                }
            };
        });