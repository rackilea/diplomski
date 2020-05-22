double buttonDistance = ...
int gridPaneColumnCount = ...
HBox buttonBox = new HBox(buttonDistance,
    oneLevelButton,
    twoLevelButton,
    threeLevelButton,
    fourLevelButton,
    fiveLevelButton,
    sixLevelButton,
    sevenLevelButton,
    eightLevelButton,
    nineLevelButton);

addQButtonPane.add(buttonBox, 1, 9, gridPaneColumnCount-1, 1);