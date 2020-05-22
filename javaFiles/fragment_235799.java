//Need shape=JsonFormat.Shape.OBJECT to suppress default array deserialization behavior
@JsonFormat(shape=JsonFormat.Shape.OBJECT) 
public class I18NProperty<T> extends ArrayList<I18NProperty.Content<T>>{

    public static class Content<T> {
        public Locale i18n;
        public T val;
    }

    @JsonAnySetter
    public void set(String key, T value) {
        Content<T> c = new Content<T>();
        c.i18n = new Locale(key);
        c.val = value;
        this.add(c);
    }
}