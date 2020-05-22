private T[] data;

@SuppressWarnings("unchecked")
public CastIssue(Class<T> clazz) {
    this.data = (T[])Array.newInstance(clazz, 1);
}