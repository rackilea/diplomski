private PanelOfLabel[] PanelOfLabels = new PanelOfLabel[5];

public PanelOfBoxes() {
    super();
    createBoxes();
}

public void createBoxes() {
    for (int i = 1; i < checkBoxs.length; i++) {
        checkBoxs[i] = new JCheckBox();
        checkBoxs[i].setSelected(true);
        this.add(checkBoxs[i]);
        checkBoxs[i].addItemListener(new MyListener(PanelOfLabels[i]));
    }
}