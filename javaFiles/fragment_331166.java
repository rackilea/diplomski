BMW bmw = new BMW();
Benz benz = new Benz();

public class CarFactory{

    public void create(Car car){
        if(car instanceof Benz)
            Benz benz = (Benz) car;
        else 
            BMW bmw = (BMW) car ;
    }
}