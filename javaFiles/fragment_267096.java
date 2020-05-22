public class LaunchAppTestAction extends ActionSupport {

private static final long serialVersionUID = -367986889632883043L;

//private ProcessDate pd = new ProcessDate();

private String processDateInput=null;

public String getProcessDateInput() {
    return processDateInput;
}

public void setProcessDateInput(String processDateInput) {
    this.processDateInput = processDateInput;
}

public String execute() throws Exception {      
    System.out.println("Process Date : "+processDateInput);
    return SUCCESS;
}}