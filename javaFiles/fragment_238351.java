public MyButton(String text, Icon icon) {
    arrowIcon = createDefaultArrowIcon();
    mainButton = new JButton(text, icon);
    popupButton = new JButton(arrowIcon);

    mainButton.setBorder(BorderFactory.createEmptyBorder());
    popupButton.setBorder(BorderFactory.createEmptyBorder());

    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    add(mainButton);
    add(new JSeparator(VERTICAL));
    add(popupButton);

    setModel(new DefaultButtonModel());
    init(null, null);
}

@Override
public void updateUI() {
    setUI((ButtonUI)UIManager.getUI(this));
}

@Override
public String getUIClassID() {
    return "ButtonUI";
}