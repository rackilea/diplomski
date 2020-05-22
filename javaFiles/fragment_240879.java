// import com.example.Foo.Bar.Baz;
import java.io.Serializable;

public class Foo implements Serializable {
    public final Bar bar;

    public Foo(Bar bar) {
        this.bar = bar == null ? new Bar(Bar.Baz.ONE) : bar;
    }

    public static class Bar implements Serializable {
        public enum Baz {
            ONE
        }
        public final Baz baz;
        public Bar(Baz baz) {
            this.baz = baz;
        }
    }
}