@MappedSuperclass
public abstract class SecuredDataObject extends DataObject {

    @Version
    @Column(name = "Version")
    private int version;

    @Basic
    @Column(name = "SecurityId", nullable = true)
    private Integer securityId;

    // Note - method IS NOT final
    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }   

    // Note - method IS final
    public final int getVersion() {
        return version;
    }

    public final void setVersion(final int version) {
        this.version = version;
    }
}