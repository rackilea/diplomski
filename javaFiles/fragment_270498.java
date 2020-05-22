@RequestMapping(
        consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
        produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(HttpStatus.OK)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Get {

    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};
}

@Get(value = "/users")
public UserResponse retrieveUsers() {
    return new UserResponse();
}