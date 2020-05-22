/**
 * Populate the {@link MessageTransformingHandler} instance for the provided
 * {@link GenericTransformer} for the specific {@code payloadType} to convert at
 * runtime.
 * @param payloadType the {@link Class} for expected payload type. It can also be
 * {@code Message.class} if you wish to access the entire message in the transformer.
 * Conversion to this type will be attempted, if necessary.
 * @param genericTransformer the {@link GenericTransformer} to populate.
 * @param <P> the payload type - 'transform from' or {@code Message.class}.
 * @param <T> the target type - 'transform to'.
 * @return the current {@link BaseIntegrationFlowDefinition}.
 * @see MethodInvokingTransformer
 * @see LambdaMessageProcessor
 */
public <P, T> B transform(Class<P> payloadType, GenericTransformer<P, T> genericTransformer) {