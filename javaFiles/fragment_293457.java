public abstract class Person 
{   
    public void buyFood(String foodName, int payment)
    {
        System.out.println("Buy " + foodName + " and pay $" + payment + ".");
        pay(payment);
    }

    public abstract void pay(int amt);
}

public class Visitor extends Person
{      

    @Override  
    public void pay(int amount)
    {
        money_v -= amount;
        System.out.println(this.to_s() + " has got HK$" + money_v + "left.");
    }

}