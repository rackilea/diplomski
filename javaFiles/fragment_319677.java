public interface DevObject<T extends DevObject<T>> { 
    void addExtension(DevExtension<T> extension);
}

public interface DevExtension<T extends DevObject<T>> {
    void start(T devObject); 
}