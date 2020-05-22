FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("MainScreen.fxml"));
Parent root = (Parent)loader.load();
Player player = new Player(loader.getController());
Scene scene = new Scene(root);

. . .

public class Player {
  private InterfaceHandler ui;   

  public Player(InterfaceHandler ui) {
    this.ui = ui;
  }

  public void setNameLabel() {
    String name = "Dan";
    ui.setName(name);
  }
}