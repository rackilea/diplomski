@XmlAccessorType(XmlAccessType.PROPERTY)
public class Container {
// ...
@XmlTransient    
public Map<String,Foo> getElements(){
    return elements;
}
private List<Property> property;
@XMLElement
public List<Property> getProperty(){
    List<Property>  props = elements.entrySet().stream()
                            .map( e -> new Property( e.getKey(), e.getValue() )
                            .collect( Collectors.toList() );
    return props;
}