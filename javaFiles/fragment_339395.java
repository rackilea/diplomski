public static void main(String[] args) {
    Double min = Double.MAX_VALUE;
    Double mintwo = Double.MAX_VALUE;

    for (int i=0; i < args.length; i++) {
        Double temp = Double.parseDouble(args[i]);
        if (temp < min) {
            mintwo = min;
            min = temp;
        }
        else if (temp < mintwo) {
            mintwo = temp;
        }
    }

    System.out.println(min);
    System.out.println(mintwo);
}