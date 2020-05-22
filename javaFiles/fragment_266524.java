public class StatelessConcreteStrategy implements Strategy {

    @Override
    public void perform() {
        new ConcreteStrategy().perform();
    }
}