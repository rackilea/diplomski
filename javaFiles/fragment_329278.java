@MappedSuperclass
public abstract class ClassificationAbstract implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumns(value = {
            @JoinColumn(name = "YEAR", referencedColumnName = "YEAR", nullable = false),
            @JoinColumn(name = "CLASS_TYPE_GUID", referencedColumnName = "GUID", nullable = false)
    })
    private ClassificationType classificationType;

    public ClassificationType getClassificationType() {
        return classificationType;
    }
    public void setClassificationType(ClassificationType classificationType) {
        this.classificationType = classificationType;
    }
}