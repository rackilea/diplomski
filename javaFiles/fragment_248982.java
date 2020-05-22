public class test {
    static int pi = 1;
    public static void main (String args[]){
        System.out.println("Yum! Pi!");
        varCreate();
        varAdd();
    }
    public static void varCreate () {
        pi++;
    }
    public static void varAdd () {
        System.out.println(pi);
    }
}