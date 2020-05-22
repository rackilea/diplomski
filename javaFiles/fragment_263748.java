This turned out relatively easy to implement, so now there is:

class DeserializationContext {
   public JavaType getContextualType() { ... }
}
which will give expected type during call to createContextual(), including case of deserializers that are directly added via annotation.