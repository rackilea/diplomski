public class Adapter1
    extends XmlAdapter<String, List<CustomId>>
{


    public List<CustomId> unmarshal(String value) {
        return (Class1.fromString(value));
    }

    public String marshal(List<CustomId> value) {
        return (Class1.toString(value));
    }

}