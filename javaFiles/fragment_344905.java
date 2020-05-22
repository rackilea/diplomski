public static void main(String...args) {
    Dog snoopy = new Dog("snoopy");
    snoopy.bark();
    Dog.bark = new AggressiveBarkingStrategy();
    snoopy.bark();
}