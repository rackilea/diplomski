@RequestScoped
@ManagedBean(name = "navigationBean")
public class NavigationBean {

    @ManagedProperty(name = "printableBehaviorBean", value="#{printableBehaviorBean}")
    private PrintableBehaviorBean printableBehaviorBean;

    public void setPrintableBehaviorBean(PrintableBehaviorBean printableBehaviorBean) {
        this.printableBehaviorBean = printableBehaviorBean;
    }

    public PrintableBehaviorBean getPrintableBehaviorBean() {
        return printableBehaviorBean;
    }

    public String search() {
        printableBehaviorBean.setOutputMode("default");
        return "search";
    }

}