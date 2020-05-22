labelTurn.textProperty().bind(Bindings.createStringBinding(() -> {
    String s = " ";
    if (content.getWhiteTurnProp().get())
        s = "White, it is your turn.";
     else
        s = "Black, it is your turn.";

    return s;
}, content.getWhiteTurnProp()));