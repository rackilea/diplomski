private UIPanel panel;

// getter and setter


// Action method, might also work in a @PostConstruct
public String showComponent() {
    if (showComponent1) {
        UIOutput component1 = new HtmlOutputText();
        component1.setValue("Hello world!");

        getPanel().getChildren().add(component1);
    }

    return "viewId";
}