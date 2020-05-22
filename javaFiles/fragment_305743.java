class MyDslLabelProvider extends DefaultEObjectLabelProvider {

    @Inject
    new(AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }
    // xtext does reflective polymorphic dispatch on params
    def text(StructCreator ele) {
        ele.id
    }

    def text(ClassCreator ele) {
        ele.id
    }

}