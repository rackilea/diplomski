Tab tabB = new Tab();
tabB.setText("");
tabPane.getTabs().add(tabB);
tabB.setStyle("-fx-border-color:red; -fx-background-color: blue;");
tabB.setGraphic(new Label("Tab B"));
tabB.getGraphic().setStyle("-fx-text-fill: #c4d8de;");