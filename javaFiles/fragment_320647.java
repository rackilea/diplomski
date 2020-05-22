public interface ProcedurecodeEntityRepository extends JpaRepository<ProcedurecodeEntity, Integer> {
    @Query("select pc.procedurecodeid, pc.amounttype from ProcedurecodeEntity pc " + 
          "join pc.sectionContent sc " +
          "join pc.sectionContent.section s " + 
          "where pc.benefitid = ?1 " +
          "and s.sectiontitle = ?2 " +
          "and s.cdtversionid = ?3")
   ProcedurecodeEntity findByBenefitIdAndSectionTitleAndCdtVersionId(long benefitid, String sectiontitle, long cdtversionid);
}