// This is type-safe because query is known to be a JPA named query.
// We use ? extends because query may be a more specific concrete type,
// and because we cannot add to the list owned by query.
@SuppressWarnings("unchecked")
List<? extends NumericConfig> resultListTyped = query.getResultList();
results = resultListTyped;