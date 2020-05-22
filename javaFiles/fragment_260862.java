@Entity
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Convert(converter = SkillConverter.class)
    private SkillInterface skill;
}

public class SkillConverter implements AttributeConverter<SkillInterface,String> {
    @Override
    public String convertToDatabaseColumn(SkillInterface skill) {
        return skill.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public SkillInterface convertToEntityAttribute(String dbData) {
        //works as a factory
        if (dbData.equals("noskill")) {
            return new NoSkill();
        } else if (dbData.equals("axe")) {
            return new Axe();
        }
        return null;
    }
}

public interface SkillInterface {
    public String getSkill();

    void attack();
}


public class NoSkill implements SkillInterface{
    public String getSkill() {
        return getClass().getSimpleName();
    }

    @Override
    public void attack() {
        //strategy statements
    }
}