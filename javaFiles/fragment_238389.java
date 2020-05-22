public abstract class Bird implements Animal {
    private BirdProcessor processor = new BirdProcessor();
    public abstract float getWingspan();
    @Override
    public AnimalProcessor<Bird> getProcessor() {
        return processor; 
    }
}

public class BirdProcessor implements AnimalProcessor<Bird> {
    @Override
    public void process(Bird b) {
        System.out.print("Wingspan is " + b.getWingspan());
    }
}