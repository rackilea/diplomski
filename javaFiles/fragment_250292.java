public static int calculate(int a[]){
    Random random = new Random();
    HashSet<Integer> remaining = new HashSet<Integer>();
    for (int i = 0; i < a.length; i++) {
        remaining.add(i);
    }
    int i = 0;
    while (!remaining.isEmpty()) {
        int index = random.nextInt(a.length);
        System.out.print(a[index] + " ");
        remaining.remove(index);
        i++;
    }
    System.out.println();
    System.out.println("Finished after " + i + " iterations.");
    return i;
}