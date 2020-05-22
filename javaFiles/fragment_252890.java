@Entity
@Table(name = "x_skill_level")
public class SkillLevelModel {
   // ...
   @OneToMany(mappedBy="skm", fetch=FetchType.LAZY)
   private List<SkillModel> skills;
   // ...
}

@Entity
@Table(name = "x_skill")
public class SkillModel {
   // ...
   @ManyToOne
   @JoinColumn(name="skill_level_id", referencedColumnName="id", nullable=true, updatable=false, insertable=false)
   private SkillLevelModel skm;
   // ...
}