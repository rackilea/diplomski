import com.google.inject.util.Types;

@SuppressWarnings("unchecked")
public static <T> TypeLiteral<Set<T>> setOf(Class<T> type) {
    return (TypeLiteral<Set<T>>)TypeLiteral.get(Types.setOf(type));
}