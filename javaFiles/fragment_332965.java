import java.util.List;
import java.util.Map;
import java.util.function.Function;

class Big {
    String director;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
}

public class Ex2 {
    Map<String, Function<Big, List<String>>> mappers = Map.of(
            "A", a -> List.of(a.a, a.b),
            "B", a -> List.of(a.c, a.d)
    );

    public List<String> parse(Big input) {
        return mappers.get(input.director).apply(input);
    }
}