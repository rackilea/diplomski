@Target({FIELD})
@Retention(RUNTIME)
public @interface Process {

    Class<? extends ProcessingStrategy> using() default com.example.processing.DefaultImplStrategy.class;

}