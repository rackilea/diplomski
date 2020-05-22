public class Special extends BaseEntity implements Serializable {
    ...
    @JsonIgnore
    public ApplicationInstance getAppInstance() {
        return this.appInstance;
    }
    ...
}