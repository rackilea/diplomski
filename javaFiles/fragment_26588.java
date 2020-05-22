import oracle.bpel.services.workflow.task.model.ObjectFactory; 
import oracle.bpel.services.workflow.task.model.CommentType; 
import oracle.bpel.services.workflow.task.model.IdentityType; 

...

ObjectFactory factory = new ObjectFactory() 

CommentType commentType = factory.createCommentType(); 

IdentityType updatedBy = factory.createIdentityType(); 
updatedBy.setId("some user"); 
updatedBy.setType(IWorkflowConstants.IDENTITY_TYPE_USER); 
updatedBy.setDisplayName("some user display name"); 

commentType.setUpdatedBy(updatedBy); 
commentType.setComment("some comment"); 

...set the rest of the comment fields as necessary... 