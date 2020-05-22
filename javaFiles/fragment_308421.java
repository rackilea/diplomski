@Stateless
public class MySessionBean implements MySessionLocal {

    @PostConstruct
    private void init() {

        try {
            final InitialContext initialContext = new InitialContext();// must use the no-arg constructor

            final String myString = (String) initialContext.lookup("java:comp/env/myString");
            final Boolean myBoolean = (Boolean) initialContext.lookup("java:comp/env/myBoolean");
            final Double myDouble = (Double) initialContext.lookup("java:comp/env/myDouble");
            final Long myLong = (Long) initialContext.lookup("java:comp/env/myLong");
            final Float myFloat = (Float) initialContext.lookup("java:comp/env/myFloat");
            final Integer myInteger = (Integer) initialContext.lookup("java:comp/env/myInteger");
            final Short myShort = (Short) initialContext.lookup("java:comp/env/myShort");
            final Byte myByte = (Byte) initialContext.lookup("java:comp/env/myByte");
            final Character myCharacter = (Character) initialContext.lookup("java:comp/env/myCharacter");
        } catch (NamingException e) {
            throw new EJBException(e);
        }
    }
}