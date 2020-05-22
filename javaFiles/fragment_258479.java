class Demo{

    public static void main(String[] args){

         //assuming we have the classes Car and Bus which implement the Interface
         // Vehicle
         Car mycar = new Car(); //Creates new Instance of Car on the Heap
         Bus mybus = new Bus(); //Creates new Instance of Bus on the Heap


         // Now let's try to access them with our interface.
         // By doing so you lose access to all methods and 
         // attributes of your car/bus which are not described in your
         // Interface! 
         Vehicle myvehicle = new Vehicle(); //This will not work!
         Vehicle myvehicle = mycar; //This is fine

         // Lets assume there is another class called "Bike" which 
         // cannot be instantiated directly (keyword: Singleton) but  
         // implements Vehicle             
         Bike mybike = new Bike(); //This won't work!
         Vehicle mybike = Bike.getInstance(); //This is fine
    }
}