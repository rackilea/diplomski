public class Mapping {
    @XmlElement
    @XmlJavaTypeAdapter(ParameterAdapter.class)
    private List<Parameter> mParameters;

    //getters setters
}