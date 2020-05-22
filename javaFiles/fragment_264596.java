@Repository
public class OrganisationRepositoryImpl implement OrganisationRepository {

    private final Neo4jUtils neo4jUtils;


    List<Organisation> findOrg(String orgCode) {

        Map<String, Object> params = map("orgCode", orgCode);

         String query = "MATCH (n:Organisation)-[r:HAS_SUB_ORGANIZATION*]->(m:Organisation) "+
        " where n.code = {orgCode} return " +
        " n.code, "+
        " n.name, "+ 
        " m is not null haschildren ," +
        " m as children" +
    return neo4jUtils.cypher(query, params)
                .map(this::mapToOrganization)
                .collect(toList());
    }

    private OrganizationDTO mapToOrganization(Map<String, Object> map) {
        OrganizationDTO org = new OrganizationDTO(
            map.get("n.code"), map.get("n.name"));
        if((Boolean)map.get("haschildren")){
            org.setChilren(m.get("children");
        }

    }
}