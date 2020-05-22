public synchronized void destroyFood(Food item){
     Iterator<Food> iter = food_array.iterator();
     while(iter.hasNext()){
         iter.remove(); // <-- this is how you remove elements while iterating
         break;
     }      
 }