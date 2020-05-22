//O(n) efficiency if you don't need to resize, O(n^2) if you do

    public void insert(int number) {
           if(size / pq.length >= 75) {
               pq = resize(); 
               //You would have to make resize return an Integer[] and 
               //implement this throughout the code
           }
           for(int i = 0; i < pq.length; i++) {
                 if(pq[i] == null) {
                     pq[size] = number;
                     size++;
                     return;
                 }
           }
     }