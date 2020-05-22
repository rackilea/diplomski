abstract class Handler{
    public static <T> void registerHandler(Class<T extends Handler> clazz){
        Constructor<T> c = clazz.getConstructor(Event.class); // say, you have to construct subclasses to handle an event
        // a lot of try-catch trouble
    }
}