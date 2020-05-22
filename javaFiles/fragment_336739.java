int []t=new int[n-indx-1];
//       /-- grouped initializers      /-- grouped increments
//       |                             |
for(int i=0, j= indx+1; i < t.length; i++, j++){
    t[i]=a[j];
}
return t;