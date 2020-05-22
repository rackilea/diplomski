import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
class Parent {

    public static void main(String[] args) throws JAXBException {

        final Child child = new Child();
        child.age = 55;

        final Parent parent = new Parent();
        parent.child = child;

        final JAXBContext context = JAXBContext.newInstance(Parent.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                               Boolean.TRUE);
        marshaller.marshal(parent, System.out);
        System.out.flush();
    }

    @XmlElement
    public Integer getAge() {
        return child == null ? null : child.age;
    }

    @XmlTransient
    private Child child;
}

class Child {

    @XmlElement
    protected Integer age;
}