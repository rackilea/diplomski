@Component(id = "myComponent")
private MyComponent myComponent;

@SetupRender //or any other render event method
private void setup() {
    Object compVariable = myComponent.getYourVariable();
}