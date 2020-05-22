/**
 * This is a HACK to work around a not yet implemented feature. At the moment Spring Hateoas uses a
 * {@link ConversionService}, which is hold in a private static final field and hence cannot be accessed to add more
 * Converters<br/>
 *
 * <ul>
 *   <li><a href="https://github.com/spring-projects/spring-hateoas/issues/118">Spring Hateoas Issue</a></li>
 *   <li><a
 *     href="http://stackoverflow.com/questions/22240155/converter-from-pathvariable-domainobject-to-string-using-controllerlinkbuilde">
 *     Solution on Stackoverflow</a></li>
 * </ul>
 */
public static class HateoasConversionServicePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof ConversionService) {
            try {
                Class<?> clazz = Class.forName(
                        "org.springframework.hateoas.mvc.AnnotatedParametersParameterAccessor$BoundMethodParameter");
                Field field = clazz.getDeclaredField("CONVERSION_SERVICE");
                field.setAccessible(true);

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

                field.set(null, bean);

                modifiersField.setInt(field, field.getModifiers() & Modifier.FINAL);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }
}