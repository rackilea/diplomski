@Stateless
public class MySessionBean implements MySessionLocal {

    @Resource(name="myString")
    private String striing;

    @Resource(name = "myDouble")
    private Double doouble;

    @Resource(name = "myLong")
    private Long loong;

    @Resource(name = "myName")
    private Float flooat;

    @Resource(name = "myInteger")
    private Integer inteeger;

    @Resource(name = "myShort")
    private Short shoort;

    @Resource(name = "myBoolean")
    private Boolean booolean;

    @Resource(name = "myByte")
    private Byte byyte;

    @Resource(name = "myCharacter")
    private Character chaaracter;

}