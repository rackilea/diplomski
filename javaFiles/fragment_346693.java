public class Run{ 
  public static void main(String[] args) { 
    GUI gui = new GUI();
    Debug debug = new Debug();

     debug.setGui(gui);
     gui.setDebug(debug);

     gui.startGui();
  } 
}