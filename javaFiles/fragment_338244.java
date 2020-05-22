public class ReflectionUtils {

public static void nullifyStrings( Object o ) {

    for ( Field f : o.getClass().getDeclaredFields() ) {
        f.setAccessible(true);
        try {
            if ( f.getType().equals( String.class ) ) {
                String value = (String) f.get( o );
                if ( value != null && value.trim().isEmpty() ) {
                    f.set( o , null);
                }
            }
        } catch ( Exception e ) { 
            throw new RuntimeException(e);
        }
    }

}

}