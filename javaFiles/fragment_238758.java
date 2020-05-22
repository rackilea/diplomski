private ToggleButton createButton(String text, ToggleGroup group) {
    ToggleButton buttonPanelForSymbols = new ToggleButton(text);
    // Current code here
    buttonPanelForSymbols.setToggleGroup(group)
    return buttonPanelForSymbols;
}