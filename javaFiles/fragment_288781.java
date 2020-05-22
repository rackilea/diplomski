for(int i=0; i<a.length; i++) {
   for(int j=i+1; j<a.length; j++) {
      if(a[j] < a[i]) {
          int x= a[i];
          a[i] = a[j];
          a[j] = x;
      }
   }
}