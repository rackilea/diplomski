package snippet;

public class MainExample {

    public static void main(String[] args) throws Exception {

        MainExample s = null; //A variable containing null

        MainExample[] ss = {s}; //An array containing, the object referenced by your variable, errr... null

        s = new MainExample(); //The varible references a new object

        System.out.println(ss[0]); //The array still contains null
    }
}