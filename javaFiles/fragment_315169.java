ChangeListener<Number> componentListener = (obs, oldValue, newValue) -> 
    color.set(Color.rgb(r.get(), g.get(), b.get());
r.addListener(componentListener);
g.addListener(componentListener);
b.addListener(componentListener);

color.addListener((obs, oldColor, newColor) -> {
   r.set((int)/(256*newColor.getRed()));
   g.set((int)/(256*newColor.getGren()));
   b.set((int)/(256*newColor.getBlue()));
});

colorPicker.valueProperty().bindBidirectional(color);