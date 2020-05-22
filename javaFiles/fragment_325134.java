public class MergeSort {
  public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

     int a[]={2,4,5,7,1,2,3,6};

     System.out.println("Unsorted Array");
     for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
     }
     try{
        MergeSort m=new MergeSort();
        a=m.merge(a, 0, 3, 7);
     }catch(Exception e ){
        e.printStackTrace();
     }
     System.out.println("\nSorted Array");
     for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
     }
  }

  int [] merge(int a[],int p,int q,int r){
  //int a[]={2,4,5,7,1,2,3,6};
  int n1=q-p+2;
  int n2=r-q+1;

  int L[]=new int[n1];
  int R[]=new int[n2];

  for(int i=0;i<n1 -1;i++){
    L[i]=a[p+i];
  }
  L[n1 -1] = Integer.MAX_VALUE;
  //q=q+1;
  for(int i=0;i<n2 -1;i++){
    R[i]=a[q+i+1];
  }
  R[n2-1] = Integer.MAX_VALUE;

  //L[n1+1]=9;
  ///R[n2+1]=9;

  int i=0,j=0;

  for(int k = p; k <= r; k++){
      if(L[i] <= R[j]){
        a[k] = L[i++];
    }else{
        a[k] = R[j++];
    }
  }
  return a;
 }
}