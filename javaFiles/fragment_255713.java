@Repository
    public interface Entity1Repository extends JpaRepository<Entity1, Integer> {

    Set<Enity1> findByEntity2In(List<Integer> pEntities2Ids);

}