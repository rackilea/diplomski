public static void main(String[] args) {
    try {
        System.out.println(new Calculator().distance(10, false)); // 10 km
        System.out.println(new Calculator().distance(10, true)); // 10 m
    } catch (IllegalArgumentException e) {
        System.out.println("You pass wrong arguments to the method!");
    }
}