public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int[] a;


  int n=sc.nextInt();
  a=new int[n];

  for(int i=0; i<a.length; i++) // Remove = from for loop
    {
    a[i]=sc.nextInt();
  }

  for(int i = a.length - 1; i>0; i--) // Modify here 
  {
    System.out.println(a[i]);
  }

 } 
}