public final class SubClassBuilder extends AbstractSubClassBuilder<SubClass, SubClassBuilder> {

    private SubClassBuilder(SubClass obj) {
        super(obj, SubClassBuilder.class);
    }

    public static SubClassBuilder neu () {
        return new SubClassBuilder(new SubClass());
    }
}