public class Achievement {
    //...name, etc
    private final AchievementValidator validator;
}

public interface AchievementValidator {
    public boolean isSatisfied(Data userData);
}