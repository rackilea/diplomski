//O(1) efficiency if you don't need to resize, O(n) if you do

public void insert(int number) {
       if(size / pq.length >= 75) {
           pq = resize();
       }
       pq[size] = number; //Since this will be the first non-empty index
       size++;
       return; //Doing it this way, if you can, is much more efficient than looping
}