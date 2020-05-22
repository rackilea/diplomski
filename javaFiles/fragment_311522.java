public class App 
{
    @Inject
    private Car car;

    public void main(@Observes ContainerInitialized event)
    {
        car.startCar();
        car.stopCar();
    }
}