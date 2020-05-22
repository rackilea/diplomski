import java.util.Arrays;

public static String revio(String[] a){
  int N = a.length;
  String reverse = new String[N];
  for (int i = 0; i < N ; i++) {
  reverse[i] = a[N-i-1];  
  }
  return Arrays.toString(reverse); 
  }

 //using StringBuilder
  public static String revio(String[] a){
  int N = a.length;
  StringBuilder reverse = new StringBuilder();
  for (int i = 0; i < N ; i++) {
  reverse.append(a[N-i-1]);  
  }
  return reverse.toString(); 
  }


public static void main (String[] args)
{
  String[] myArray = {"1", "2", "3"};  
  String arr = revio(myArray);
  System.out.println(arr);
}