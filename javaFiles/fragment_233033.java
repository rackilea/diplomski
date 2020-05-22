Random r = new Random();
int[]arr = new int[5];

for(int i=0;i<arr.length;i++)
{
    arr[i] = Math.abs(r.nextInt()%255) +1;
    System.out.print(arr[i] + "\t");
}

System.out.println();
Arrays.sort(arr);
for(int item: arr)
    System.out.println(item);