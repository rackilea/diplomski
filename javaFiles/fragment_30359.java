import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users_skills")
public class UserSkill {

    @EmbeddedId
    private UserSkillId id;

    @ManyToOne
    @JoinColumn(name = "fk_user", insertable = false, updatable = false)
    @JsonIgnoreProperties("skills")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_skill", insertable = false, updatable = false)
    @JsonIgnoreProperties("users")
    private Skill skill;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

        public UserSkill() {
        }

        ...
}