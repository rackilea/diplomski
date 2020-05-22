@RequestMapping(method = RequestMethod.POST,
        consumes = "appilcation/json",
        produces = "appilcation/json")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}

@RequestMapping(value = "/relative_path")
@MyAnnotation
public User method1(HttpServletRequest httpServletRequest,
                  @RequestBody String requestBody) { }