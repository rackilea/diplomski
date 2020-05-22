enum SomeDataProvider {

    SOME_ENUM_ARRAY_PROVIDER([SOME_ENUM_1, SOME_ENUM_2]);

    private List<SomeAnnotation> array

    SomeDataProvider(def array) {
         this.array = array
    }

    public List<SomeAnnotation> getSomeEnumArray() {
       return array;
    }
}