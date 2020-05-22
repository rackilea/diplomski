static class Y {
   int val;
   public Y(int val){
      this.val=val;
   }
} 

static class W extends Y implements Comparable<Y>{
   public W(int val){
      super(val);
   }
   public int compareTo(Y o){
      return this.val-o.val;
   } 
}

W[] array = new W[10];
for (int i = 0; i < array.length; ++i)
    array[i] = new W(i);

System.out.println("Count > 5 = " + countGreaterThan(array, new Y(5)));