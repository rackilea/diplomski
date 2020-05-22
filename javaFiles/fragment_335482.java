public static void main(String[] args) { // first bracket

    final int dollar = 2;
    System.out.println("i can access dollar: " + dollar);

    {
        final int euro = 33;
        System.out.println("I can access dollar: " + dollar + ", and i can access euro: " + euro);
    }

    // you have to remove +euro to compile this:
    System.out.println("But i cant access euro because i am outside the brackets where euro is declared: " + euro);
}