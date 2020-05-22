package snippet;

public class MainExample {

    public static void main(String[] args) throws Exception {

        MainExample s = null;

        MainExample[] ss = null;

        s = new MainExample();

        ss = new MainExample[]{s};

        System.out.println(ss[0]);
    }
}