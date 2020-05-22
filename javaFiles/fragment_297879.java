public class NullAwareLocalDateArgumentFactory extends LocalDateArgumentFactory {
    @Override
    public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
        if(value == null){
            //Look at the expected type. Tbh. not sure why it isn't simply doing this by default ...
            return LocalDate.class.isAssignableFrom(expectedType);
        }
        else {
            return super.accepts(expectedType, value, ctx);
        }
    }
}