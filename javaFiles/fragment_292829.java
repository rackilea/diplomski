public abstract class SuperClass {

    {
        if (!isInitialized(getClass())) {
            initialize(getClass());
        }
    }

}