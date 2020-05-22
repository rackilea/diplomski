public interface MyTableRepository extends JpaRepository<MyTable, Long> {
    //....

    @Modifying
    @Query(
            value = "truncate table myTable",
            nativeQuery = true
    )
    void truncateMyTable();
}