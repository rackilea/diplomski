public class Main {

    String x = "a";
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        System.out.println(x); //"a"
        String x = "b";
        System.out.println(x); //"b"
        new Thread(new Runnable() {
            public void run() {
                String x = "c"; 
                System.out.println(x); //"c"
            }
        }).start();
        System.out.println(x); //"b"
    }

    public void method(){
        System.out.println(x); //"a"
    }
}