ArrayList<Integer> inpudData = new ArrayList<Integer>();

if (args.length < 1) {
System.out.println("Proper Usage is: java IntArraySort < sort.dat");
System.exit(0);
} else {
    for (int i = 0; i < args.length; i++)
    inpudData.add(Integer.parseInt(args[i]));
}