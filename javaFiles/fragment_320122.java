private ComboBox<Integer>methode;

  methode.setOnAction((event) -> {
      int number = methode.getSelectionModel().getSelectedItem()
      paneYouWantToChange.getChildren().clear() // removes all displayed item

      /*Or if you want to replace somehting in your pane*/
      paneYouWantToChange.getChildren().set(indexOfItemToReplace, new TextField())

      /*Add new textfields*/
      paneYouWantToChange.getChildren().addAll(new TextField(), new TextField())
  });