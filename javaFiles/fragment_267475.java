class MyPOJO implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Parsed(field = "UniqueCode")
    private String            code;
    @Parsed(field = "Name")
    private String            name;
    @Parsed(index = 2) //anything goes here, "catId", "cowId", etc
    private String            someOtherId;

    ...
}