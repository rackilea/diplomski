public class Cat{
    public static final Predicate<Cat> BLACK_PREDICATE = new Predicate<Cat>(){
            public boolean evaluate( Cat c ) {
                return c.isBlack();
            }
        };

    // Rest of the Cat class goes here
}