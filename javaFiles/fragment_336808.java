package stackoverflow;

public class CompilerOptimize {
    public static void main(String[] args){
        System.out.println(sayHello());
    }

    private static String sayHello(){
        return "Hello World";
    }

    private static void bananas() {
        System.out.println("Monkey!");
    }
}