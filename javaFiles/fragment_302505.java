public static void cast() {
    for (int i=0; i<1000000; i++) {
        int x= (int)Math.random();
    }
}

public static void format() {
    for (int i=0; i< 1000000; i++) {
        DecimalFormat df = new DecimalFormat("#");
        df.format(Math.random());
    }
}