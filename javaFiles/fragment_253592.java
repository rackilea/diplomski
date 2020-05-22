import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int iterations = scan.nextInt();
    int i = 0;
    int len,x;
    int j,initial;
    long migrated;
    int arr[] = new int[1000005];
    while(i<iterations)
    {
      len = 0;
      while(true)
      {
        x = scan.nextInt();
        if(x==0)
          break;
        arr[len++] = x;
      }
      initial = arr[0];
      migrated = 0;
      j = 1;
      while(j<len)
      {
        if(arr[j]-(2*initial)>0)
        {
          migrated += arr[j]-(2*initial);
        }
        initial = arr[j];
        j++;
      }
      System.out.println(migrated);
      i++;
    }
  }
}