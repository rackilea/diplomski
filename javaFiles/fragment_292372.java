public class CommonParentResource extends ServerResource
{
    public void doInit()
    {
        boolean authorized=false;

        String sid = getRequestAttributes().containsKey("sid") ? (String)getRequestAttributes().get("sid") : StringUtils.EMPTY;

        // Authorization logic here.

        if(!authorized)//after authorization process completed.
        {
            getResponse().setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
            getResponse().setEntity(/*Representation carrrying message for unauthorized user*/);
        }
    }
}