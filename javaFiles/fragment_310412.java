private volatile InstanceInfo<T> instanceInfo;
...
public T getInstance() {
    // we store this in a non-volatile to only touch the volatile field once and to
    // ensure we have a consistent view of the instanceInfo value
    InstanceInfo<T> localInstanceInfo = instanceInfo;
    if (localInstanceInfo == null || !Arrays.equals(currentKey, localInstanceInfo.key)) {
       localInstanceInfo = new InstanceInfo<>(currentKey, constructor.get());
       instanceInfo = localInstanceInfo;
    }
    return localInstanceInfo.instance;
}
...
private static class InstanceInfo<T> {
   final Object[] key;
   final T instance; 
   public InstanceInfo(Object[] key, T instance) {
       this.key = key;
       this.instance = instance;
   }
}