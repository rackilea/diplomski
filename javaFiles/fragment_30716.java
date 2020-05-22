/** Annotation declaration */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface isSearchable{
    //...   
}

@isSearchable
public String anyField = "any value";