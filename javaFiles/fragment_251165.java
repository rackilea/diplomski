public class Factory {

    public static A getA(String propertyValue) {

        switch(propertyValue) {

        case "B1": return new B1(); 
        case "B2": return new B2();
        default: throw new RuntimeException("unsupported class");

        }

    }
}