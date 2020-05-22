public class Main {
   private GUI gui;
   Main() {
   }
   public void setGui(GUI gui) {
      this.gui = gui;
   }
}

public class GUI {
   private Main main;
   public GUI() {
   }
   public void setMain(Main main) {
      this.main = main;
   }
}

public static void main(String[] args) {
   Main main = new Main();
   GUI gui = new GUI();
   main.setGui(gui);
   gui.setMain(main);
}