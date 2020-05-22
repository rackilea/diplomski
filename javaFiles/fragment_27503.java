@Service
public class TestService
{
    public void doSomeGets()
    {
        List<String> tenants = getListSomehow();
        try(MultitenancyTemporaryOverride tempOverride = new MultitenancyTemporaryOverride())
        {
            for(String tenant : tenants)
            {
                tempOverride.setCurrentTenant(tenant);
                //do some work here, which only applies to the tenant
            }
        }
        catch (Exception e)
        {
            logger.error(e);
        }
    }
}