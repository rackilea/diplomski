public class Test2 {
    static int user = 10;

    public static void increase_user() {
        int number = 3;
        if (number < 10)
            user++;
    }

    public static void main(String[] args) {
        increase_user();
        System.out.println(user);
    }
}