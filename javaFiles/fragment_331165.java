public abstract class Car{
    public abstract void power();
}

public class BMW extends Car{
    public void power(){
        System.out.println(2200);
    }
}

public class Benz extends Car{
    public void power(){
        System.out.println(2100);
    }
}