public void addElement(int element) {
       if(size == capacity) {
           System.out.println("array is full");
           return;
       }
       numbers[size++] = element;
}