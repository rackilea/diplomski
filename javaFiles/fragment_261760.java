IDeliverableHandle deliverable= ... // Find a deliverable using one of
the IWorkItemClient#findDeliverable* methods

IAttribute foundIn= workItemClient.findAttribute(project,
  IWorkItem.FOUND_IN_PROPRTY, monitor);
workItem.setValue(foundIn, deliverable);