@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(NoProfilesEnabledCondition.class)
public @interface NoProfilesEnabled {
    String[] value();
}