@Query("MATCH (g:Group) where g.id = {groupId} " +
        "optional match (g)-[:MEMBER_OF]->(t:Tenant) " +
        "return g, collect(t.id) as tenantIds")
Optional<GroupWithTenantIds> findById(Long groupId);

@QueryResult
static class GroupWithTenantIds {
  Group group;
  Set<Long> tenantIds;
}