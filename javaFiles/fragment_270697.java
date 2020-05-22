int[][] array=new int[1][3];
int[] sub=array[0];
sub[0]=1; sub[1]=2; sub[2]=42;
System.out.println(Arrays.deepToString(array));
array=new int[2][];
System.out.println(Arrays.deepToString(array));
array[0]=sub; array[1]=sub;
System.out.println(Arrays.deepToString(array));