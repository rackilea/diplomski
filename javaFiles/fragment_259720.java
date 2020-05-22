@JacksonXmlRootElement(localName = "channel")
public class Channel

{
    private String title;
    private String link;
    public Channel(){
    }
    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Item> items;
    //----getters...settters
 }