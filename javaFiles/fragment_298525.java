@Override
public Set<Method> getQueryMethods() {

    Set<Method> result = new HashSet<Method>();

    for (Method method : getRepositoryInterface().getMethods()) {
        method = ClassUtils.getMostSpecificMethod(method, getRepositoryInterface());
        if (isQueryMethodCandidate(method)) {
            result.add(method);
        }
    }

    return Collections.unmodifiableSet(result);
}

/**
 * Checks whether the given method is a query method candidate.
 * 
 * @param method
 * @return
 */
private boolean isQueryMethodCandidate(Method method) {
    return isQueryAnnotationPresentOn(method) || !isCustomMethod(method) && !isBaseClassMethod(method);
}