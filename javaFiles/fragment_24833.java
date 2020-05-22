import java.util.EnumMap;

public class Clazz extends AbstractClazz<Numbers> {

    @Override
    public boolean isVisible(EnumMap<Numbers, Object> visibleConditions) {
        return false;
    }
}