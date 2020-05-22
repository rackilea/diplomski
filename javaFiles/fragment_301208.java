public interface GenerateKeyRepository extends JpaRepository<KeyEntity, Integer> {

    @Query(value= "SELECT * FROM tb_key", nativeQuery = true)
    List<KeyEntity> getAll();

    public void findOneByCompanyId(Integer companyid);
}