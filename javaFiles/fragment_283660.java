@GraphQLDirective //Should be mapped as a GraphQLDirective
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD}) //Applicable to methods
public @interface Auth {
        String requiredRole();
}