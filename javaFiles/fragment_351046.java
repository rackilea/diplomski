public class CodeGen extends Task {
    private String className = null;
    private List properties = new ArrayList();

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Called by ant for every &lt;property&gt; tag of the task.
     *  
     * @param property The property.
     */
    public void addConfiguredProperty(Property property) {
      properties.add(property);
    }

    public void execute() throws BuildException {
        // here we go!
    }

}