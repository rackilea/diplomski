class Container {
    private SomeType data;

    class ContainerExample extends Example {
        protected SomeType getParentData() {
            return data;
        }
    }
}