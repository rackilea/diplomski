Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DumpToFile {

      String fileName() default "default value";

}