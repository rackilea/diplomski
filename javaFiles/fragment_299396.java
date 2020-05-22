@SuppressWarnings("unchecked")
public <T extends Enum<T>> T getMode(Class<T> key) {
    if (key == MANAGER_MODE.class)
        return (T) managerMode;
    throw new IllegalArgumentException("Unknown mode type: " + key.getName());
}