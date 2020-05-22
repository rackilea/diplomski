/**
 * Constructs a new type literal. Derives represented class from type
 * parameter.
 *
 * <p>Clients create an empty anonymous subclass. Doing so embeds the type
 * parameter in the anonymous class's type hierarchy so we can reconstitute it
 * at runtime despite erasure.
 */
@SuppressWarnings("unchecked")
protected TypeLiteral() {
  this.type = getSuperclassTypeParameter(getClass());
  this.rawType = (Class<? super T>) MoreTypes.getRawType(type);
  this.hashCode = type.hashCode();
}