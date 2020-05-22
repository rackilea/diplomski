public class Particle {
    public boolean update() {
        if (life <= 0) {
            return false; // remove me!
        }
        this.x += xa;
        this.y += ya;
        life--;
        return true; // update successful
    }
}

public class Level {
    public boolean update() {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            if (!p.update()) {
                it.remove(); // Remove is O(1) with LinkedList
            }
        }
        return true; // update successful
    }
}