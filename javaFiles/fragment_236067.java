@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Contraint(validatedBy = DocumentTypeValidator.class)
@Documented
public @interface ValidDocumentType {

    String message() default "{com.mycompany.constraints.invaliddocument}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] value();
}