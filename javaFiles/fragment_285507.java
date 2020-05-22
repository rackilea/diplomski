import java.util.ArrayList;
public class QuicksortJava {  

 public static void swap(ArrayList<Long> a, long i, long j) {  
  long temp = a.get((int)i);  
  a.set((int)i, a.get((int)j));  
  a.set((int)j, temp);  
 }  

 public static void quicksort(ArrayList<Long> a, long L, long R) {  
  long m = a.get((int)(L + R) / 2);  
  long i =  L;  
  long j =  R;  
  while (i <= j) {  
   while (a.get((int)i) < m)  
    i++;  
   while (a.get((int)j) > m)  
    j--;  
   if (i <= j) {  
    swap(a, i, j);  
    i++;  
    j--;  
   }  
  }  
  if (L < j)  
   quicksort(a, L, j);  
  if (R > i)  
   quicksort(a, i, R);  
 }  

 public static void quicksort(ArrayList<Long> a) {  
  quicksort(a, 0, a.size() - 1);  
 }  

 public static void main(String[] args) {  

  // Sample data  
  long size = 100000;
  ArrayList<Long> a = new ArrayList<Long>((int)size);  
  for (long i = 0; i < size; i++) {  
   a.add(i * 3 / 2 + 1);  
   if (i % 3 == 0)  
    a.set((int)i, -a.get((int)i));  
  }  

  long t1 = System.currentTimeMillis();  
  quicksort(a);  
  long t2 = System.currentTimeMillis();  
  System.out.println(t2 - t1);  

 }  

}