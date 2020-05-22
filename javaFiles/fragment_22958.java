public static void main(String[] args) throws FileNotFoundException {
    String input = args[0];
    for (int i = 1; i < args.length; i++) {
        System.out.println(" File  " + args[i]);
        File one = new File(args[i]);
        Scanner in = new Scanner(one);
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.contains(input)) {
                System.out.println(line);
            }
        }
    }
}