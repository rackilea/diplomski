public class Main {
    public static void main(String[] args) {
        Boolean[] array = new Boolean[10];
        if(array[0]) // <--- NullPointerException HERE
            System.out.println("true");
        else
            System.out.println("false");
    }
}