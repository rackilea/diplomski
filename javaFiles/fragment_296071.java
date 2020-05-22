/**
 * Finds the version attribute for ManagedType instance.
 * @param managedType The metaobject
 * @return The version attribute or null, if it does not have one
 * @throws UnsupportedOperationException
 * If it has a version attribute, but is not one of supported types, as specified in {@link Version} documentation
 * (currently int, Integer, short, Short, long, Long, Timestamp).
 */
private static <T> SingularAttribute<? super T, ?> findVersionAttribute(ManagedType<T> managedType) {
    if ( !(managedType instanceof IdentifiableType))
        return null;

    IdentifiableType<T> identifiableType = (IdentifiableType<T>)managedType;
    if ( ! identifiableType.hasVersionAttribute())
        return null;

    try {
        return identifiableType.getVersion(int.class);
    } catch (IllegalArgumentException e) {
        try {
            return identifiableType.getVersion(Integer.class);
        } catch (IllegalArgumentException e1) {
            try {
                return identifiableType.getVersion(long.class);
            } catch (IllegalArgumentException e2) {
                try {
                    return identifiableType.getVersion(Long.class);
                } catch (IllegalArgumentException e3) {
                    try {
                        return identifiableType.getVersion(short.class);
                    } catch (IllegalArgumentException e4) {
                        try {
                            return identifiableType.getVersion(Short.class);
                        } catch (IllegalArgumentException e5) {
                            try {
                                return identifiableType.getVersion(Timestamp.class);
                            } catch (IllegalArgumentException e6) {
                                throw new UnsupportedOperationException("The version attribute is not of supported type");
                            }
                        }
                    }
                }
            }
        }
    }
}