@Service
public class CompanyResourceServiceImpl implements CompanyResourceService {

@PersistenceContext
    private EntityManager entityManager;

...

private int getMetalResourceByPlayerId(int theId) {

        StoredProcedureQuery theQuery = entityManager.createNamedStoredProcedureQuery("getAllMetalFromCompaniesByPlayerId");

        theQuery.setParameter("Param1", theId);

        BigDecimal outAmount = (BigDecimal) theQuery.getSingleResult();

        return  outAmount.intValue();
    }

...

}