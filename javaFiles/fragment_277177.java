public class Main {
static int[] diff(int arr[], int n){
 int index1=0;
 int index2=0;
 int maxdiff=0;
 int[] ans=new int[3];
 int i,j;
 for (i=0; i<n-1; ++i){
//   for (j=i+1; j>i; --j){
//     if(arr[i]>arr[j] && maxdiff<Math.abs(arr[i]-arr[j]))
//     maxdiff=Math.abs(arr[i]-arr[j]);
//     index1=i;
//     index2=j;
//     ans[0]=index1;
//     ans[1]=index2; 
//     ans[2]=maxdiff;
//
//  }
     if(maxdiff<Math.abs(arr[i]-arr[i+1]))
     {
         maxdiff=Math.abs(arr[i]-arr[i+1]);
         ans[0]=i;
         ans[1]=i+1;
         ans[2]=maxdiff;
     }
 }
return ans;

}

 public static void main(String[] args) {
   Main max = new Main();
   int arr[]={1,20,2,6,11,16,8};
   int n=arr.length;
   int[] ans=max.diff(arr, n);
    System.out.println("i="+ans[0]);
    System.out.println("j=" + ans[1]);
    System.out.println(ans[2]);
  }
}