public class SkillStrategyFactory {

    private static final Map<String, SkillStrategy> skillStrategyMap;

    static {
        skillStrategyMap = new HashMap<>();
        skillStrategyMap.put(Constants.BARBARIAN, new BarbarianSkillStrategy());
    }

    public static SkillStrategy getStrategy(DnDClass dndClass) {
        return skillStrategyMap.get(dndClass.getClassName());
    }
}