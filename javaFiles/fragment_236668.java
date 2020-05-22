public void push(E target) {
         if (isFull()) {     
            stretch();
         }
         data[size] = target;
         size++;
   }