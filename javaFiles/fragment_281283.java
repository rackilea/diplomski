@Repository
public interface BaseDetailsRepo extends JpaRepository<BaseDetails, String>{
//make the return according to you ..it shouldn't be list....

    @Query("FROM SecondDetails AS bd WHERE bd.identifier=:identifier")
    public List<SecondDetails> getSecondDetailsByIdentifier(@Param("identifier") String identifier);

    @Query("FROM FirstDetails AS bd WHERE bd.identifier=:identifier")
    public List<FirstDetails> getFirstDetailsByIdentifier(@Param("identifier") String identifier);          
}