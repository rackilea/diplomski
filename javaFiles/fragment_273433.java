public class someBean implements Serializable {
    private ApplicationBean applicationBean

    @In
    protected void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }
    ...
}