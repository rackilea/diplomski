import java.util.Properties;


public class Main
{
    public static void main(String[] args)
    {
        final Properties         properties;
        final PropertiesVerifier verifier;

        properties = new Properties();
        properties.put("property.one",   "true");
        properties.put("property.two",   "false");
//        properties.put("property.three", "5");
        verifier = new PropertiesVerifier(
            new PropertiesVerifier.PropertyInfo[]
            {
                new PropertiesVerifier.PropertyInfo("property.one",   
                                                    true, 
                                                    Boolean.class),
                new PropertiesVerifier.PropertyInfo("property.two",   
                                                    false, 
                                                    Boolean.class),
//                new PropertiesVerifier.PropertyInfo("property.three", 
//                                                    true, 
//                                                    Boolean.class),
            });

        System.out.println(verifier.isKnown("property.one"));
        System.out.println(verifier.isKnown("property.two"));
        System.out.println(verifier.isKnown("property.three"));

        System.out.println(verifier.isRequired("property.one"));
        System.out.println(verifier.isRequired("property.two"));
        System.out.println(verifier.isRequired("property.three"));

        System.out.println(verifier.isOptional("property.one"));
        System.out.println(verifier.isOptional("property.two"));
        System.out.println(verifier.isOptional("property.three"));

        System.out.println(verifier.getType("property.one"));
        System.out.println(verifier.getType("property.two"));

        // System.out.println(verifier.getType("property.tthree"));
        System.out.println(verifier.isValid("property.one", "true"));
        System.out.println(verifier.isValid("property.two", "false"));
        // System.out.println(verifier.isValid("property.tthree", "5"));


        verifier.verifyProperties(properties);
    }
}