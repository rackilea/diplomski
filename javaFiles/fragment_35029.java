ToggleButton first = new ToggleButton("A");
    ToggleButton second = new ToggleButton("B");
    ToggleGroup group = new ToggleGroup();
    first.setToggleGroup(group);
    second.setToggleGroup(group);
    second.selectedProperty().addListener((p, ov, nv) -> {
        System.out.println("Changed");
    });