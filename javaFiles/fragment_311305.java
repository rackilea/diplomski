ScpNeoTenant currentTenant = (ScpNeoTenant)TenantAccessor.getCurrentTenant();
TenantContext currentTenantContext = currentTenant.getTenantContext();

currentTenantContext.execute("anotherTenantId", new Callable<MyResult>() {
    @Override
    public MyResult call() {
        return new RequestContextExecutor().execute(new Callable<MyResult>() {
            @Override
            public MyResult call() {
                Tenant tenant = TenantAccessor.getCurrentTenant();
                // ...
                return myResult;
            }
        });
    }
});