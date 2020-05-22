@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AlsoSaveRecord { 
   // The record class type
   Class<?> value();
}