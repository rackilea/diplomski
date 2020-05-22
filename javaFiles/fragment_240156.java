public class AjaxUpdateEvent
{
    public AjaxRequestTarget target;

    public AjaxUpdateEvent( AjaxRequestTarget target )
    {
        this.target = target;

    }

    public AjaxRequestTarget getTarget()
    {
        return this.target;
    }

}