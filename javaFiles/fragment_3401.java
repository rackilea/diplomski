public class GameDraw extends JComponent {
   ...
}

public class Man implements KeyListener {
    ...
    private GameDraw draw;

    public Man(GameDraw draw) {
        ...
        this.draw = draw;
    }
    ...
}

class GameFrame extends JFrame {
  ...
  private GameDraw component;

  public GameFrame() {
    ...
    component = new GameDraw();
    Man man = new Man(component);
    component.addKeyListener(man);
    ...
  }
}