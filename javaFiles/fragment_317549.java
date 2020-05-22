@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dashboardreport")
public class Dashboardreport {

    @XmlElementWrapper(name = "data")
    @XmlElements({
        @XmlElement(name = "chartdashlet", type = Chartdashlet.class),
        @XmlElement(name = "incidentchartdashlet", type = Incidentchartdashlet.class)
    })
    protected List<Dashlet> dashlets;

    @XmlAttribute(name = "name")
    protected String name;
}