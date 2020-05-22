TabPane tabPane = new TabPane();
BorderPane borderPane = new BorderPane();

Tab tab = new Tab();
tab.setText("Google");
VBox hbox = new VBox();//you are not using this
hbox.setAlignment(Pos.CENTER);
tab.setContent(hbox);//you replaced this
tabPane.getTabs().add(tab);

tab.setContent(new OuroborosBrowser(scene));//you see?
// bind to take available space

borderPane.setCenter(tabPane); // why this? its not needed
return borderPane;