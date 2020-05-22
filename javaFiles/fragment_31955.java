// POJO with JAXB annotations

@XmlRootElement(name = "sensor")
public class MyObject {
    @XmlID
    @XmlElement
    private String id;

    @XmlAttribute
    private String name;

    @XmlElement(name = "sensor-value")
    private Integer value;

    @XmlTransient // don't translate to XML
    private Double computedValue;

    // ...getters and setters
}


// POJO with REST interface

@Path("/mywebservice")
public class MyWebService {
    @EJB
    MySensorController controller;

    @GET
    @Produces("application/xml")
    public MyObject getCurrentSensorValue(@QueryParam("ID") String id) {
        // automatic unmarshalling from MyObject to XML
        return controller.getSensorValue(id);
    }
}