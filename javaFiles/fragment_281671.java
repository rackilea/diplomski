public static void main(String[] args) {

    int i = 0;
    String result;
    long time;

    time = System.currentTimeMillis();
    while (i < Integer.MAX_VALUE) {
        result = ""+i;
        i++;
    }
    System.out.println("Option 1: " + (System.currentTimeMillis() - time));

    i = 0;
    time = System.currentTimeMillis();
    while (i < Integer.MAX_VALUE) {
        result = new StringBuilder("").append(i).toString();
        i++;
    }
    System.out.println("Option 1b: " + (System.currentTimeMillis() - time));

    i = 0;
    time = System.currentTimeMillis();
    while (i < Integer.MAX_VALUE) {
        result = String.valueOf(i);
        i++;
    }
    System.out.println("Option 2: " + (System.currentTimeMillis() - time));

    i = 0;
    time = System.currentTimeMillis();
    while (i < Integer.MAX_VALUE) {
        result = Integer.toString(1);
        i++;
    }
    System.out.println("Option 3: " + (System.currentTimeMillis() - time));

}