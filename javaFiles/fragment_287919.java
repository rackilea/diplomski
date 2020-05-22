class MammalBuilder<B extends MammalBuilder<B>> {
    ...
}
class RabbitBuilder<B extends RabbitBuilder<B>>
        extends MammalBuilder<B> {
    ...
}