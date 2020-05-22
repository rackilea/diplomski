public class LoudDog implements IDog {
    @Override
    public void bark() {
        System.out.println("WUUUUFF");
    }

    // Does not work, compile error as IDog does not declare this method
    @Override
    public void fly() {
        System.out.println("I wanna fly :(");
    }
}