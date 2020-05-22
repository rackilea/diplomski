import java.util.EnumMap;
import java.util.HashMap;

public abstract class AbstractClazz<K extends Enum<K>> {

    public abstract boolean isVisible(EnumMap<K, Object> visibleConditions);
}