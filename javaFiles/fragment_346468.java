public abstract class T {
...
}
public class NonTerminal extends T {
    private Map<String,T> map = new HashMap<>();
...
}
public class Terminal extends T {
    private List<String> list;
---
}