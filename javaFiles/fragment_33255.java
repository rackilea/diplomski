public static void main(String[] args) {
    Singleton one = Singleton.getInstance();
    Singleton two = Singleton.getInstance();
    if (one == two) {
        System.out.println("One instance");
    }
}