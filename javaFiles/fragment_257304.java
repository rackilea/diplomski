public static void main (String[] args){
    if (args.length < 2) {
        System.out.println("I need two command line arguments!");
        return;
    }
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = a + b;
    System.out.println("jumlah "+c);
}