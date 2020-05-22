ToggleButton first = new ToggleButton("A");
    ToggleButton second = new ToggleButton("B");
    ToggleGroup group = new ToggleGroup();
    first.setToggleGroup(group);
    second.setToggleGroup(group);
    second.selectedProperty().addListener((p, o, n) -> {
        System.out.println("Changed "+p.getValue());
    });
    second.setOnAction(a -> {
        System.out.println("Action");
    });
    second.onActionProperty().addListener((p, o, n) ->{
        System.out.println("OnAction");

    });