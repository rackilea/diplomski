public class MyState extends State {
  MyState(Game g) {
    super(g);
  }

  public void tick() {
    System.out.println("tick");
  }

  public void render(Graphics g) {
    System.out.println("I am rendering!");
    //render the MyState
  }
}

State s = new MyState(myGame);