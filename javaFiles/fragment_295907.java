final TenantUtil.TenantRunAsWork<Map<String, Long>> runAsWork = () -> {
    final Map<String, String> td = new HashMap<>();
    td.put("userCount", (long) personService.countPeople());

    long totalUsage = 0L;
    for (NodeRef personNodeRef : personService.getAllPeople()) {
        totalUsage += (long) serviceRegistry.getNodeService().getProperty(personNodeRef, ContentModel.PROP_SIZE_CURRENT);
    }
    totalUsage = totalUsage / (1_024L * 1_024L);
    td.put("totalUsage", totalUsage);

    return td;
};
final Map<String, Long> tenantData =
    TenantUtil.runAsTenant(runAsWork, tenantDomain);