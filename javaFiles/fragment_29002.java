@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, 
ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { MyValidator.class })
public @interface MyValidationAnnotation {

/**
 * @return
 */
String message() default "Your value is not valid";

/**
 * @return
 */
Class<?>[] groups() default {};

/**
 * @return
 */
Class<? extends Payload>[] payload() default {};