private Class<T> type;
private Class arrType;

public BaseService(Class<T> type) {
    this.type = type;
    arrType = Array.newInstance(type, 0).getClass();
}