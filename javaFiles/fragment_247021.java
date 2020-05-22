int arr[][]={{1},{2,2},{5,2,2},{2,0,5,8},{8,7,9,4,5}};

int size=5;

for(int x=0; x < size; x++)
{
    int sum = 0;
    for(int y=x; y < size; y++)
    {
        sum += arr[y][x];
    }
    System.out.println("Column " + x + " Sum=" + sum + "\n");
}