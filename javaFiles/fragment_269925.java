@Override
public void accept(T t) {
    if (take = predicate.test(t)) {
        downstream.accept(t);
    }
}

@Override
public boolean cancellationRequested() {
    return !take || downstream.cancellationRequested();
}