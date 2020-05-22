import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("forum14571803");

        ObjectFactory objectFactory = new ObjectFactory();

        Parameters parameters = objectFactory.createParameters();
        parameters.getParamNameAndParamValue().add(objectFactory.createParametersParamName("A"));
        parameters.getParamNameAndParamValue().add(objectFactory.createParametersParamValue("a"));
        parameters.getParamNameAndParamValue().add(objectFactory.createParametersParamName("B"));
        parameters.getParamNameAndParamValue().add(objectFactory.createParametersParamValue("b"));

        JAXBElement<Parameters> root = objectFactory.createParameters(parameters);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}