public class SubSubClassBuilder extends AbstractSubSubClassBuilder<SubSubClass, SubSubClassBuilder> {

    private SubSubClassBuilder(SubSubClass obj) {
        super(obj, SubSubClassBuilder.class);
    }

    public static SubSubClassBuilder neu () {
        return new SubSubClassBuilder(new SubSubClass());
    }
}