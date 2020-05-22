@XmlRootElement(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
static class Result {
    String data;
}

@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
static class Error {
    String cause;
}

public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Result.class, Error.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    String sampleErrorInput = "<Error><cause>Sample cause</cause></Error>";
    String sampleResultInput = "<Result><data>Sample data</data></Result>";
    for (String input : Arrays.asList(sampleErrorInput, sampleResultInput)) {
        Object obj = unmarshaller.unmarshal(new StringReader(input));
        if (obj instanceof Error) {
            System.out.println("Error: " + ((Error) obj).cause);
        } else if (obj instanceof Result) {
            System.out.println("Result: " + ((Result) obj).data);
        }
    }
}