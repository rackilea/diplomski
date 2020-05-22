public static void main(String[] args) {
    System.out.println("A breeding group of 20 bighorn sheep is released in a protected area in Colorado.");
    System.out.println("After the group has reached a size of 80 sheep, the group does not need to be supervised anymore.");
    System.out.println("This program calculates how many years the sheep have to be supervised.");
    double power = 1;
    boolean foundFirstOverEighty = false;
    for (int years = 0; years < 25; years++) {
        double number = 220 / (1 + 10 * power);
        System.out.println("After " + years + " years, the number of sheep is: " + number);

        if (!foundFirstOverEighty && number >= 80) {
            System.out.println("First time number of sheep exceeded eighty. " + years + " years. number of sheep is: " + number);
            foundFirstOverEighty = true;
        }

        power *= 0.83;
    }
}