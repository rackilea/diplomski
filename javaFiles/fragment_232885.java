@Override
public String getUIClassID() {
    return "CustomUI";
}

@Override
public void updateUI() {
    setUI(UIManager.getUI(this));
}