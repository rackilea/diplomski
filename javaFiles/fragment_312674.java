// Init the variables
BooleanProperty interestingMode = new SimpleBooleanProperty(false);
RadioButton classicModeButton = new RadioButton("Classic");
RadioButton interestingModeButton = new RadioButton("Interesting");
ToggleGroup tg = new ToggleGroup();

classicModeButton.setToggleGroup(tg);
interestingModeButton.setToggleGroup(tg);
tg.selectToggle(classicModeButton);

// The radios should be not focusable
classicModeButton.setFocusTraversable(false);
interestingModeButton.setFocusTraversable(false);

// On toggle-change, the mode will be changed
interestingMode.bind(tg.selectedToggleProperty().isEqualTo(interestingModeButton));

// Just print the changes
tg.selectedToggleProperty().addListener((observable, oldValue, newValue) ->
        System.out.println((newValue == interestingModeButton) ? "Hmm, interesting" : "Classic .. boring"));

scene.setOnKeyPressed(e -> 
        System.out.println((e.getCode().isArrowKey()) ? "Arrow pressed!" : "Other pressed, I don't care!"));