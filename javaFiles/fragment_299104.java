package test;
public class main {
public static void main(String [] args){
    main test = new main();
    test.addCar();

}
public void addCar() {

    Cars car1 = new Cars();
    Garage myGarage = new Garage();
    myGarage.add(car1);
    if(!(car1.getAssignedTo()).equals(null)){
        car1.getAssignedTo().setAssign(car1);
        car1.getAssignedTo().setAvailable(false);
    }
}   
}