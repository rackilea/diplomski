public static void main(String args[]){
    Car[] cars = new Car[30];
    for (int i = 0; i < 10; i++) {
        cars[i] = new Honda();
        cars[i+10] = new Nissan();
        cars[i+20] = new Subaru();
    }

}