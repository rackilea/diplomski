public interface Api {
    Single<Integer> loadFromNetwork();
}

public interface Cache {
    Maybe<Integer> loadFromCache(); //maybe because cache might not have item.
}