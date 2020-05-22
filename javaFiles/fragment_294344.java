//In the Controller class
@FXML
private Button loginButton = new Button();
//... 
//... on The  public void initialize method of the Controller
//...
loginButton.setId("loginButton");
loginButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            Object source = e.getSource();
                            if (source instanceof Button) { //always true
                               //Do whatever you want when the event occurs 
                               Button temp = (Button) source;
                                DoSomething(temp.getId());
                            }
                        }
});