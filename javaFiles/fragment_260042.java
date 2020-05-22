public static void main(String[] args){
   Car[] cars=new Car[3];
   cars[0]=new Car("Audi","ModelName");
   cars[1]=new Car("BMW","ModelName");
   cars[2]=new Car("Honda","ModelName");

   for(int i=0;i<cars.length;i++){
      System.out.println(cars[i]);
   }
}