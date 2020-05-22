ArrayList<Creature> boids = new ArrayList<Creature>();
ArrayList<Food> food = new ArrayList<Food>();
//populate ArrayLists

void draw(){

   for(Creature boid : boids){
      Iterator<Food> foodIter = food.iterator();

      while(foodIter.hasNext()){
         Food f = foodIter.next();
         float distance = PVector.dist(boid.location, food.location);
         if (distance < 0.5) {
            boid.btype = 1;
            foodIter.remove(); //removes the food
        }
      }

   }

   //draw the scene
}