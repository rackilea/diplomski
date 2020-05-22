public class Pipes extends JPanel {
    List<Pipe> pipes = new ArrayList<Pipe>();

    public Pipes() {
        pipes.add(new Pipe(50, 100));
        pipes.add(new Pipe(150, 100));
        pipes.add(new Pipe(250, 100));
    }
}