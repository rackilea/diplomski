@XmlRootElement(name="Crm")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrmDTO extends ParentDTO {

    @XmlElement(name = "codigo")
    private Long CODIGO;

    @XmlElement(name = "uf")
    private String UF;

    @XmlElement(name = "crm")
    private String CRM;

    @XmlElementWrapper(name="Especialidade")
    @XmlElements({
      @XmlElement(name="codigo", type=Long.class),
      @XmlElement(name="name", type=String.class)
    })
    private List<Object> especialidades;

}