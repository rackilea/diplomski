public static void main(String[] args) {
    List<Integer> intlist = new ArrayList<Integer>();
    for (int i = 0; i < args.length; i++) {
        intlist.add(Integer.parseInt(args[i]));
    }

    for (int number : intlist) {
        int sqrt = (int) (Math.floor(Math.sqrt(number)));
        if (sqrt * sqrt == number && intlist.contains(sqrt)) {
            System.out.print("yes ");
        } else { 
            System.out.print("no ");
        }

    }
}