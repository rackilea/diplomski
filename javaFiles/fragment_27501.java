public class MultitenancyTemporaryOverride implements AutoCloseable
{    
    static final ThreadLocal<String> tenantOverride = new NamedThreadLocal<>("temporaryTenantOverride");

    public void setCurrentTenant(String tenantId)
    {
        tenantOverride.set(tenantId);
    }

    public String getCurrentTenant()
    {
        return tenantOverride.get();
    }

    @Override
    public void close() throws Exception
    {
        tenantOverride.remove();
    }
}