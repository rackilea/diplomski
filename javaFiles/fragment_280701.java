Item items = this.getQueryOne(); 
// getQueryOne() returns the Item object
for (Workflow workflow: items.getWorkflow()) {
   System.out.println(workflow.getActor());
   System.out.println(workflow.getDate());
}