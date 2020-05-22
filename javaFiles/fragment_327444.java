class Cube{ 
  public static void main(String args[]){ 
    int i,j=0,sum=0; int arr[]=new int[10]; 
    Scanner scan=new Scanner(System.in); 
    String s=scan.nextLine(); 

    String[] str=s.split(" ");
    for(i=0;i<=str.length;i++){ 
        int temp = Integer.parseInt(str[i]);
        sum+=Math.pow(3,temp); 
    } 
  } 
}