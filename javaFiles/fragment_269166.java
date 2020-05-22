public class ExtensionOpener {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("args:");

        for(String arg: args) 
            System.out.println(arg);

        Thread.sleep(3000);
    }
}