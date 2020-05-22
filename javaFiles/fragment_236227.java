Scanner in = new Scanner(System.in);
int x = 0;

System.out.println("How many number do you want to put?");
int b = in.nextInt();

int[] a = new int[b];

for (int z = 0; z < b; z++) {
    System.out.println("Input your" + " " + (z + 1) + " " + "number");
    a[z] = in.nextInt();
}

for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}