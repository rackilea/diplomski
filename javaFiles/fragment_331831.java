public class AutomationProjectsList {

    private List<AutomationProject> automationProjects = new ArrayList<AutomationProject>();

    public List<AutomationProject> getAutomationProjects() {
        return automationProjects;
    }

    public void setAutomationProjects(List<AutomationProject> automationProjects) {
        this.automationProjects = automationProjects;
    }

    @Override
    public String toString() {
        return "AutomationProjectsList [automationProject=" + automationProject
        + "]";
    }
}