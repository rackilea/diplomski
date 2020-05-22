class Homework {

    public static void square(int side) {
        if (side > 0) {
            for (int i = 0; i < side; i++) {
                square(-side);
            }
        } else if (side < 0) {
            System.out.print('*');
            square(side + 1);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        square(5);
    }
}