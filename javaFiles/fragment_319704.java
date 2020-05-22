@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecTime {

    public String logTime() default "true";
}