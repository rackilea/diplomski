@XmlTransient // JAXB doesn't like abstract types, so do not map this type name
// XmlSeeAlso only required if BaseImpl/BaseImpl2 are not otherwise auto-discovered by JAXB
@XmlSeeAlso({BaseImpl.class, BaseImpl2.class })
public abstract class Base {
  @XmlElement(name='still-works')
  public String thisFieldWillStillBeMappedByJAXB;
}

@XmlRootElement("base-impl")
public class BaseImpl {}

@XmlRootElement("alternative")
public class BaseImpl2 {}

public class Complex<E extends Base> {
   @XmlElementRefs({
     @XmlElementRef(type=BaseImpl.class), 
     @XmlElementRef(type=BaseImpl2.class)
   })
   public E impl; // will be an instance of either "base-impl" or "alternative"
}