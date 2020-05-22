public interface MyRepository extends JpaRepository {

    public static final String WHERE_PART = "e.companyId = :companyId AND e.deleted = false AND e.primaryAddress.deleted = false ";

    @Query(value = "SELECT e FROM Employee e LEFT JOIN FETCH e.addresses a " +
        "WHERE " + MyRepository.WHERE_PART
        "ORDER BY e.id, a.id",
        countQuery="SELECT count(e) FROM Employee e WHERE " + MyRepository.WHERE_PART
    )
    Page<Employee> findAllEmployeesWithAddressesForCompany(@Param("companyId") long companyId, Pageable pageable);