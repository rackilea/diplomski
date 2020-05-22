private IntegerProperty currentQuestionIndex = new SimpleIntegerProperty();

// ...

// label.setText(text[0]);
label.textProperty().bind(Bindings.createStringBinding(() -> 
    text[currentQuestionIndex.get()], currentQuestionIndex);

next.disableProperty().bind(currentQuestionIndex.isEqualTo(text.length -1 ));

// next.setOnAction(e -> makeLabel());
next.setOnAction(e -> currentQuestionIndex.set(currentQuestionIndex.get()+1));