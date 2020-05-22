public static void processCar(ArrayList<Car> cars){
    int totalAmount=0;
    for (int i=0; i<cars.size(); i++){
        int totalprice= cars.get(i).computeCars ();
        totalAmount=+ totalprice; 
    }
}