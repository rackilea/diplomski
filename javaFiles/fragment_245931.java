@XmlRootElement(
name = "tenantConfiguration"
)
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(
value = "TenantConfiguration",description = "This class carries all 
information related to a Tenant     configuration"
)
public class TenantConfiguration implements Serializable {
@XmlElement(
    name = "type"
)
@ApiModelProperty(
    name = "type",
    value = "type of device",
    required = true
)
private String type;
@ApiModelProperty(
    name = "configuration",
    value = "List of Configuration Entries",
    required = true
)
@XmlElement(
    name = "configuration"
)
private List<ConfigurationEntry> configuration;

public TenantConfiguration() {
}

public String getType() {
    return this.type;
}

public void setType(String type) {
    this.type = type;
}

public List<ConfigurationEntry> getConfiguration() {
    return this.configuration;
}

public void setConfiguration(List<ConfigurationEntry> configuration) {
    this.configuration = configuration;
 }
}