@Root(name="entry")
public class OddsEntryXMLObject{
    @Attribute(name="key")
    private String key;

    @Attribute(name="jackpot", required=false)
    private String jackpot;

    @Attribute(name="type", required=false)
    private String type;

    @Element(name="value")
    private OddsValueXMLObject value;
}

@Root(name="value")
public class OddsValueXMLObject{
    @ElementList(inline=true)
    private java.util.List<OddsAmountXMLObject> amounts;

    @Element(name="winner", required=false)
    private String winner;

    @Element(name="description", required=false)
    private String description;
}

@Root(name="amount")
public class OddsAmountXMLObject{
    @Attribute(name="stake", required=false)
    private String stake; 

    @Text
    private String text;
}