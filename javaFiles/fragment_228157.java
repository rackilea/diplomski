@RequestMapping(value = "/relative_path", 
    method = RequestMethod.GET,
    consumes = "appilcation/json",
    produces = "appilcation/json")
@ResponseBody
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}