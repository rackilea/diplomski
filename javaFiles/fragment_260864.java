public @interface ExistAccountWithUsername {


String message() default "your message";
Class[] groups() default {};

Class[] payload() default {};

boolean acceptNull() default true;

}