class Painter {
    Graphics g;

    public Painter(Graphics g) {
        this.g = g;
    }

    public void paint(Paintable p) {
        p.paint(g);
    }
}

interface Paintable {
    void paint(Graphics g);
}

class Player implements Paintable {
    public void paint(Graphics g) {
        // do your paint here
    }
}

class GameLabel implements Paintable {
    Player player;

    public void paint(Graphics g) {
        player.paint(g);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

class GameMain {
    Painter painter;
    Player player;
    GameLabel label;

    public GameMain() {
        // set up your frame and Graphics, etc.
        Graphics g = ...; 
        painter = new Painter(g);
        player = new Player();
        label = new GameLabel();
        label.setPlayer(player);
    }

    public void doIt() {
        painter.paint(label);
    }
}