/**
 * Extend this for Mammal subtype builders.
 */
abstract class GenericMammalBuilder<B extends GenericMammalBuilder<B>> {
    String sex;
    String name;

    B sex(String sex) {
        this.sex = sex;
        return self();
    }

    B name(String name) {
        this.name = name;
        return self();
    }

    abstract Mammal build();

    @SuppressWarnings("unchecked")
    final B self() {
        return (B) this;
    }
}

/**
 * Use this to actually build new Mammal instances.
 */
final class MammalBuilder extends GenericMammalBuilder<MammalBuilder> {
    @Override
    Mammal build() {
        return new Mammal(this);
    }
}

/**
 * Extend this for Rabbit subtype builders, e.g. LopBuilder.
 */
abstract class GenericRabbitBuilder<B extends GenericRabbitBuilder<B>>
        extends GenericMammalBuilder<B> {
    Color furColor;

    B furColor(Color furColor) {
        this.furColor = furColor;
        return self();
    }

    @Override
    abstract Rabbit build();
}

/**
 * Use this to actually build new Rabbit instances.
 */
final class RabbitBuilder extends GenericRabbitBuilder<RabbitBuilder> {
    @Override
    Rabbit build() {
        return new Rabbit(this);
    }
}