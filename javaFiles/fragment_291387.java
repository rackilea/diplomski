public abstract class Type {
    ...
}

public class AppleType extends Type {
    ...
}

public abstract class Query<T extends Type> {
    public abstract T doQuery(); /* Or so? */
}

public class AppleQuery extends Query<AppleType> {
    public AppleType doQuery() {...}
}