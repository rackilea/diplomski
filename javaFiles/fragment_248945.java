public class A {

    private Class<?> fooType;

    //protected should be enough for JAX-B and will
    //hide the method from the rest of your code.
    @XmlAnyElement
    protected JAXBElement<SomeObject> getSomeObjetctForJaxb() {
        return new JAXBElement<SomeObject>(new QName(fooType.getSimpleName()), SomeObject.class, getSomeObjetct());
    }

}