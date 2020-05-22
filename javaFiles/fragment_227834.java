private Map<String, Component> mapViews;
private Component currentView;
private LinearViewModel model;

public ViewModelTest() {

    // Maps the view name to the component...
    mapViews = new HashMap<>(25);
    model = new LinearViewModel();
    mapViews.put("Page01", new Page01());
    mapViews.put("Page02", new Page02());
    mapViews.put("Page03", new Page03());
    mapViews.put("Page04", new Page04());

    // Add the view names to the model...
    model.addView("Page01");
    model.addView("Page02");
    model.addView("Page03");
    model.addView("Page04");

    // Initialise out view with the first page...
    currentView = mapViews.get("Page01");
    add(currentView);

    // Monitor for changes...
    model.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            remove(currentView);
            currentView = mapViews.get(model.getCurrentView());
            add(currentView);
            revalidate();
        }
    });

}