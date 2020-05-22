public interface LoanReportRepository extends JpaRepository<LoanReport, Long> , JpaSpecificationExecutor<LoanReport> {

public final static String GET_LOAN_REPORTS = "SELECT lr FROM LoanReport lr WHERE product = :product";

@Query(GET_LOAN_REPORTS)
List<LoanReport> findByPreference(@Param("product") product);