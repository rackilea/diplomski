/**
 * Unsafe. Constructs a type literal manually.
 */
@SuppressWarnings("unchecked")
TypeLiteral(Type type) {
  this.type = canonicalize(checkNotNull(type, "type"));
  this.rawType = (Class<? super T>) MoreTypes.getRawType(this.type);
  this.hashCode = this.type.hashCode();
}