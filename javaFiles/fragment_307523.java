/* contents of Box.java */
public class Box<T>
{
    private T contents;
    private Object data;

    protected Box(T contents, Object data) {
        this.contents = contents;
        this.data = data;
    }

    public static BoxBuilder builder() {
        return new BoxBuilder();
    }

    public T getContents() {
        return contents;
    }
}

/* contents of BoxBuilder.java */
public class BoxBuilder
{
    private Object data;

    public BoxBuilder withAnything(Object o) {
        this.data = o;
        return this;
    }

    // Infers new type from argument
    public <T> TypedBoxBuilder<T> withBoxContent(T contents) {
        TypedBoxBuilder<T> builder = new TypedBoxBuilder<T>();
        builder.setData(data);
        builder.setContents(contents);

        return builder;
    }
}

/* contents of TypedBoxBuilder.java */
public class TypedBoxBuilder<T>
{
    private T contents;
    private Object data;

    public TypedBoxBuilder() {
    }

    public TypedBoxBuilder<T> withAnything(Object data) {
        this.data = data;
        return this;
    }

    public TypedBoxBuilder<T> withContents(T contents) {
        this.contents = contents;
        return this;
    }

    public Box<T> build() {
        return new Box<T>(contents, data);
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public void setData(Object data) {
        this.data = data;
    }
}