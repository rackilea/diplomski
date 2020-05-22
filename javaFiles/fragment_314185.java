@WebService(endpointInterface = "com.mycompany.ws.interfaces.IMyWS")
public class MyWS implements IMyWS {

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public static class Class1 {

    private Class2 class2;

    public Class1() {

    }

    public Class1(Class2 refClass) {
        class2 = refClass;
    }

    @XmlTransient
    public Class2 getClass2() {
        return class2;
    }

    public void setClass2(Class2 class2) {
        this.class2 = class2;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}

@XmlRootElement
public static class Class2 {

    private Class1 class1;

    public Class2() {

    }

    public Class1 getClass1() {
        return class1;
    }

    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

public List<Class1> cyclicTest() {
    //I create an instance of each class, having them a cyclic reference to the other instance
    Class2 class2 = new Class2();
    Class1 class1 = new Class1(class2);
    class2.setClass1(class1);
    return Arrays.asList(class1);
}


public static void main(String[] args) throws JAXBException {

    JAXBContext ctx = JAXBContext.newInstance(Class1.class);
    Marshaller m = ctx.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    List<Class1> class1s = new MyWs().cyclicTest();

    for (Class1 c1 : class1s){
        m.marshal(c1, System.out);
    }

}