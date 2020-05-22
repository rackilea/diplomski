@Query(
    value = "SELECT user_att_workshop.id, user_att_workshop.user_id, user_att_workshop.workshop_att_id, skill.skill_name, user_att_workshop.skill_score " + 
            "FROM user_att_workshop LEFT JOIN skill on user_att_workshop.skill_id = skill.id " + 
            "WHERE user_att_workshop.user_id = :userId " + 
            "AND user_att_workshop.workshop_att_id = :workshopId;", 
            nativeQuery = true
)
public List<UserScoreByWorkshopAtt> findUserScoreByUserIdAndWorkshopId(@Param("userId")int userId,@Param("workshopId") int workshopId);