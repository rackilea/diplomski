// View
List<Model> modelsToDisplay = controller.someFunctionToLoadModels();
for (Model m : modelsToDisplay) {
    addModelToView(m);
}

...

public void addModelToView(Model m) {
    ViewPartial vp = generateViewPartialForModel(m);
    this.viewPartials.add(vp);
}

...

public ViewPartial generateViewPartialForModel(Model m) {
    ViewPartial vp = new ViewPartial();
    vp.setLabel(m.getName());
    vp.setTextValue(m.getValue());
    return vp;
}