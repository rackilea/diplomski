class WorkflowDB {

    public void remove (ActivityDB a) {
        if (a != null) {
            this.activities.remove(a);
            a.setWorkflow(null);
        }
    }

    public void add (ActivityDB a) {
        if (a != null) {
            this.activities.add(a);    
            a.setWorkflow(this);
        }
    }

}