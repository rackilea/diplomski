public class MapObservableValue extends AbstractObservableValue {

private final Map map;

public MapObservableValue(Map map) {
    this.map = map;
}

@Override
public Object getValueType() {
    return Object.class;
}

@Override
protected Object doGetValue() {
    return map.get("test");
}

@Override
protected void doSetValue(Object value) {
    map.put("test", value);
}
}