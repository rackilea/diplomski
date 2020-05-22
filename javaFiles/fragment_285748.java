public class CustomBeanValidationPostProcessor extends 
    BeanValidationPostProcessor implements Ordered {

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE; // or another value for a proper order position
    }
}