List<Integer> list = new ArrayList<Integer>();
Scanner in = new Scanner(System.in);
int n = in.nextInt();
int[] defaultArray = new int[n];
// do validation for n
//assume n = 5 with values 1,2,0,3,2
for (int i = 0; i < n; i++) {
    int temp = in.nextInt();

    if (temp != 0) {
        list.add(temp);
        defaultArray[i] = temp;
    }
}
Integer[] positiveArray = new Integer[list.size()];
positiveArray = list.toArray(positiveArray);
System.out.println(Arrays.toString(defaultArray));  //will print [1, 2, 0, 3, 2]
System.out.println(Arrays.toString(positiveArray));  //will print [1, 2, 3, 2]