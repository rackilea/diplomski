FlowPanel headerPanel = new FlowPanel();
headerPanel.setWidth("100%");

ScrollPanel bodyPanel = new ScrollPanel();

DockLayoutPanel myApp = new DockLayoutPanel(Unit.PX);
myApp.addNorth(headerPanel, 100);
myApp.add(bodyPanel);

RootLayoutPanel.get().add();