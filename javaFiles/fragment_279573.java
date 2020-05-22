public class Main {
   private final GUI gui;
   Main() {
      gui = new GUI(this);
   }
}

public class GUI {
   private final Main main;
   public GUI(Main main) {
      this.main = main;
   }
}