public class Test {
    public static void main(String[] args) {
        Area map[][] = new Area[1][1];
        map[0][0] = new AntHillArea();
        String name = map[0][0].getClass().getSimpleName(); // returns "AntHillArea"
        System.out.println(name);
    }
}

class Area {

}

class AntHillArea extends Area {

}