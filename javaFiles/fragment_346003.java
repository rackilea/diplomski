public class GUIController extends AnchorPane implements Initializable {

..........

private final String lotOn = "/music/soundfx/lensoftruth_on.mp3";
private final String lotOff = "/music/soundfx/lensoftruth_off.mp3";

 .......

//Constructor
public GUIController(){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GUI.fxml"));
    loader.setRoot(this);
    loader.setController(this);

    try {
        loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }


.......

 }