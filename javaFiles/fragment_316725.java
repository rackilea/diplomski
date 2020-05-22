public class ControllerFactory implements Callback<Class<?>, Object> {

    private final BookingModel model ;

    public ControllerFactory(BookingModel model) {
        this.model = model ;
    }

    @Override
    public Object call(Class<?> type) {
        try {

            for (Constructor<?> c : type.getConstructors()) {
                if (c.getParameterCount() == 1 && c.getParameterTypes()[0] == BookingModel.class) {
                    return c.newInstance(model);
                }
            }

            // no appropriate constructor: just use default:
            return type.newInstance(); 

        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

}