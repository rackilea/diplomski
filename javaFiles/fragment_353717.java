@Entity
@Table(name = "company_resource")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllMetalFromCompaniesByPlayerId",
                                    procedureName = "getAllMetalFromCompaniesByPlayerId",
                                    parameters = {
                                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "playerId", type = Integer.class),
                                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "metalSum", type = BigDecimal.class)
                                    })
})
@IdClass(CompanyResourcePK.class)
public class CompanyResource {
...
}