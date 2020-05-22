public static void main(String[] args) {
    for (int moveTo = 0; moveTo < 50; moveTo++) {
        int space = moveTo > 40 ? moveTo - 40 : moveTo;
        System.out.println("" + moveTo + " " + space);
    }
    for (int moveTo = 0; moveTo < 50; moveTo++) {
        int space = moveTo % 40;
        System.out.println("" + moveTo + " " + space);
    }
}