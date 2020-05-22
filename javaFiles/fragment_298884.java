public synchronized void destroyFood(Food item){
     Iterator<Food> iter = food_array.iterator();
     while(iter.hasNext()){
         Food temp = iter.next();
         food_array.remove(temp); // <-- this is the problem
         break;
     }      
 }