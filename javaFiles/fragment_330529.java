import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws java.lang.Exception {

        new Main();
    }

    Main(){
        ArrayList<Super> list = new ArrayList<Super>();
        list.add(new Sub());
        list.add(new Sub());
        list.add(new Sub());
        for (Super s:list)
        {
            System.out.println(s.getSpeed(""));
        }
    }
}

class Super {
    public int getSpeed(String t) {
        return 0;
    }
}

class Sub extends Super {
    @Override
    public int getSpeed(String t) {
        return 1;
    }

}