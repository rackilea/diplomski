public class FooBar {

    private static final Logger log = Logger.getLogger(FooBar.class);

    //or (if you are using java.util.logging):

    private static final Logger log = Logger.getLogger(FooBar.class.getName());


}