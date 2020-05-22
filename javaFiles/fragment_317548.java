public class Unification {

    final class Box<A> {}

    final class MyMap<A, B extends Box<? extends A>> {}

    MyMap<?, ?> getMap() {
        return new MyMap<Object, Box<Object>>();
    }

    <A> void setMap(final MyMap<A, ?> m) {
        doSetMap(m);
    }

    <A, B extends Box<? extends A>> void doSetMap(final MyMap<A, B> m) {}

    void worksFineNow() {
        setMap(getMap());
    }

}