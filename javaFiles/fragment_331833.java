public class AutomationProjectsWrapper {

    private AutomationProject automation_project = new AutomationProject();

    public AutomationProject getAutomationProject() {
        return automation_project;
    }

    public void setAutomationProject(AutomationProject automationProject) {
        this.automation_project = automationProject;
    }

    @Override
    public String toString() {
        return "AutomationProjectsList [automationProject=" + automation_project
        + "]";
    }
}