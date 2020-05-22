public void initialize() {
    textArea.textProperty().bindBidirectional(toBind);

    textArea.textProperty().addListener((observable, oldValue, newValue) -> {
      System.out.print("textArea: ");
      System.out.println(newValue);
    });

    toBind.addListener((observable, oldValue, newValue) -> {
      System.out.print("toBind: ");
      System.out.println(newValue);
    });

    label.textProperty().bind(toBind);
  }