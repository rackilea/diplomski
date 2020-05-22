public class GuiClass {

private SimpleBooleanProperty guiSwitch;

public GuiClass() {
    guiSwitch = new SimpleBooleanProperty(false);
}
public SimpleBooleanProperty getGuiSwitchProp() {
    return guiSwitch;
}
public StackPane getGui() {
    StackPane root = new StackPane();
    Button btn = new Button("Click me");     
    root.getChildren().add(btn);
    btn.setOnMouseClicked(ev -> setGuiSwitch(true));
    return root;
}
public void setGuiSwitch(Boolean value) {
    this.guiSwitch.set(value);
}
public boolean getGuiSwitch() {
    return this.guiSwitch.get();
}
}