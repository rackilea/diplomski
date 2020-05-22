Scanner input = new Scanner(System.in);
int n = input.nextInt();     //n is my input number
input.nextLine();

String[] arr = new String[n];
int i,j;
for(i=0;i<n;i++)
{
    arr[i] = input.nextLine();
}