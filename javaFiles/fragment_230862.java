public void one() {...}
public void two() {...}
private final Map<String, Runnable> lookup = new HashMap<String, Runnable>() {{
    put("one", this::one);
    put("two", this::two);
}};