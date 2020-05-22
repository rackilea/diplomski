public class JoinedUserAchievementId {

    private Long userId;
    private Long achievementId;
    ...
}

public class JoinedUserAchievement {

    @EmbeddedId
    private JoinedUserAchievementId joinedUserAchievementId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(optional = false, fetch = LAZY)
    @MapsId("achievementId")
    @JoinColumn(name = "ACHIEVEMENT_ID")
    private Achievement achievement;

    //if you absolutely need to map the achievement_id column here as well
    //note that it will already be mapped to joinedUserAchievementId.achievementId
    @Column(name = "ACHIEVEMENT_ID", insertable=false, updatable=false)
    private Long achievementId;
    ...
}