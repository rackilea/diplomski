public static void main(String[] args) {
 test(System.out::println);
}

public static void test(Runnable r) {}
public static void test(Consumer<String> r) {}