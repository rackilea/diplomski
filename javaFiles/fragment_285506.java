class TestQuickSort
{

   public static Void swap(Int[] a, Int i, Int j) {  
    temp := a[i];  
    a[i] = a[j];  
    a[j] = temp;  
   }  

   public static Void quicksortA(Int[] a, Int L, Int R) {  
    m := a[(L + R) / 2];  
    i := L;  
    j := R;  
    while (i <= j) {  
     while (a[i] < m)  
      i++;  
     while (a[j] > m)  
      j--;  
     if (i <= j) {  
      swap(a, i, j);  
      i++;  
      j--;  
     }  
    }  
    if (L < j)  
     quicksortA(a, L, j);  
    if (R > i)  
     quicksortA(a, i, R);  
   }  

   public static Void quicksort(Int[] a) {  
    quicksortA(a, 0, a.size - 1);  
   }   

  static Void main(Str[] args) {  

    // Sample data  
    a := Int[,]

    for(i := 0; i<1000000; i++)
    {
      a.add(i*3/2+1)
      if(i%3==0) {a[i]=-a[i]}
    }

    t1 := Duration.now 
    quicksort(a);  
    t2 := Duration.now 
    echo((t2-t1).toMillis)  

   }  
}