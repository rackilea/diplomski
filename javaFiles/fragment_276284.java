public static Image getBlock(Color color) {
    if (blocks_hash.containsKey(color)) {
        if (color == Color.BLACK) {
            System.out.println("Black");
        } else if (color == Color.CYAN) {
            System.out.println("CYAN");
        }
    } else {
        System.out.println("non color");
    }
    return null;
}