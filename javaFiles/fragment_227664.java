public interface FastTests { /* category marker */ }
public interface SlowTests { /* category marker */ }

@Category(SlowTests.class)
public class A {
    @Test public void a() {}
}