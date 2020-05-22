CREATE OR REPLACE FUNCTION FOOBAR (p1 IN ARRAY_TEST_T ) 
RETURN VARCHAR2 AUTHID CURRENT_USER AS
LANGUAGE JAVA
NAME 'foobar.FoobarFunction.test_function(java.sql.Array)
      return lava.lang.String';


package foobar;
public class FoobarFunction {
    public static String test_function(java.sql.Array array) {
        final Object[] content = (Object[]) array.getArray();
        for (Object c : content) {
                // expecting java.sql.Struct type for c;

                // get TEST_T attribute values for c1 and c2
                final Object[] attrs = ((java.sql.Struct) c).getAttributes();
                String c1 = (String) attrs[0];
                String c2 = (String) attrs[1];
            .......
        }

        return null;
    }
}