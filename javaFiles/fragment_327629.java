import de.hybris.platform.workflow.jalo.AutomatedWorkflowTemplateJob;
import de.hybris.platform.workflow.jalo.WorkflowAction;
import de.hybris.platform.workflow.jalo.WorkflowDecision;

public class xyzJob implements AutomatedWorkflowTemplateJob 
{
    @Override
    public WorkflowDecision perform(final WorkflowAction action)
    {
        //suppose you want to get Order
        final WorkflowActionModel workflowActionModel = modelService.get(action);
        final OrderModel order = getAttachedOrder(workflowActionModel);
        ........ more code ..........
    }

}