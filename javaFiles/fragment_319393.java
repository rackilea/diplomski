float weights[]; // each >0

 public int nextIndex() {     
     float sum =0;
     for (int i=weights.length; i-->0;) sum+=weights[i];
     float r = myrandom.nextFloat()*sum;
     sum = 0;
     for (int i=0; i<weights.length-1; i++) {
         sum += weights[i];
         if (r<sum) return i;
     }
     return weights.length-1;
 }