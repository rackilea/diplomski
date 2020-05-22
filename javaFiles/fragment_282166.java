public interface G<T, U> {
    T g(U u);
}

public class C1<T, U> {
    public T f(G<T, U> g, U u) {  
        return g.g(u)
    }
}