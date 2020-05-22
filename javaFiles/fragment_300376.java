public class test {
    public static void main(String[] args) {
        Human rob = new Human(110, 100, false);
        Human bob = new Human(110, 100, true);
        Human tob = new Human(110, 100, false);
        System.out.println(rob.equals(tob));
        System.out.println(rob.equals(bob));
    }
}

class Human {
    int height;
    int weight;
    boolean alive;

    public Human(int height, int weight, boolean alive) {
        super();
        this.height = height;
        this.weight = weight;
        this.alive = alive;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (alive ? 1231 : 1237);
        result = prime * result + height;
        result = prime * result + weight;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (alive != other.alive)
            return false;
        if (height != other.height)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Human [height=" + height + ", weight=" + weight + "]";
    }
}