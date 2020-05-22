@JsonIgnoreProperties(ignoreUnknown=true)
@JacksonXmlRootElement(localName = "root")
public class BlogContent {
@JacksonXmlElementWrapper(useWrapping = false)
@JacksonXmlProperty(localName = "dynamic-element")
List dynElem;

//Constructor
...

//Getters
...

}