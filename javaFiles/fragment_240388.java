@RequestScoped
@ManagedBean(name = "printableBehaviorBean")
public class PrintableBehaviorBean {
    private String outputMode;

    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }

    public String getOutputMode() {
        return outputMode;
    }
}