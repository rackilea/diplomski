String input = "5 2 2 3 2 2";
Scanner sc = new Scanner(input);
int dimCount = sc.nextInt();
int[] dims = new int[dimCount];
for (int i = 0; i < dimCount; i++)
    dims[i] = sc.nextInt();
Object multiDimArray = java.lang.reflect.Array.newInstance(int.class, dims);