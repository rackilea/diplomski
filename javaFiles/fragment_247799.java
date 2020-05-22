public class ProfileImpl implements Profile
{
    private String name;
    private final String version;
    private List<SubsystemImpl> subsystems;
    private SettingImpl setting;

    public ProfileImpl(){
        this.version = "1.0";
        this.name = "default";
    }

    public ProfileImpl(String name, SettingImpl setting, List<SubsystemImpl> subsystems, String version){
        this.name = name;
        this.setting = setting;
        this.version = version;
        this.subsystems = subsystems;
    }

    @XmlAttribute(name = "name")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @XmlAttribute(name = "version")
    public String getVersion(){
        return version;
    }

    public void setVersion(String version){
        this.version = version;
    }

    @XmlElementWrapper(name = "subsystems")
    @XmlElement(name = "subsystem")
    public List<SubsystemImpl> getSubsystems(){
        return subsystems;
    }

    public void setSubsystems(List<SubsystemImpl> subsystems){
        this.subsystems = subsystems;
    }

    public SettingImpl getSetting(){
        return setting;
    }

    public void setSetting(SettingImpl setting){
        this.setting = setting;
    }
}