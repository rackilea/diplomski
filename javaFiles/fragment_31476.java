@XmlRootElement
class Container {
     //...

     //without XmlElementWrapper <shapes> element will be omitted
     @XmlElementWrapper(name="shapes")
     @XmlElementRef
     public List<Shape> getShape() {
          //your logic here
     }
}