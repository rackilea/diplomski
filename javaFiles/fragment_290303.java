public interface IPlayer {
    void printGreeting();
}

public class Player implements IPlayer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void printGreeting() {
        system.out.println('Your turn! (or whatever)');
    }
}

public class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public void printGeeting() {
        // NO-OP
    }

}