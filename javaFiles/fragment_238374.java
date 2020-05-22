public class Worker {
    private int strength;
    private float speed;
    private String name;
    private String specialty;

    public Worker(int str, float spd, String n, String spc) {
        strength = str;
        speed = spd;
        name = n;
        specialty = spc;
    }

    public void do() {
        System.out.println("Worker " + name + " performs " + strength + " " + specialty + " at " + speed + " times per minute.");
    }
}