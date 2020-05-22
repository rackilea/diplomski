@Stateless
public class MySessionBean implements MySessionLocal {

    @Resource
    private SessionContext sessionContext;

    @PostConstruct
    private void init() {

        final String myString = (String) sessionContext.lookup("myString");
        final Boolean myBoolean = (Boolean) sessionContext.lookup("myBoolean");
        final Double myDouble = (Double) sessionContext.lookup("myDouble");
        final Long myLong = (Long) sessionContext.lookup("myLong");
        final Float myFloat = (Float) sessionContext.lookup("myFloat");
        final Integer myInteger = (Integer) sessionContext.lookup("myInteger");
        final Short myShort = (Short) sessionContext.lookup("myShort");
        final Byte myByte = (Byte) sessionContext.lookup("myByte");
        final Character myCharacter = (Character) sessionContext.lookup("myCharacter");
    }
}