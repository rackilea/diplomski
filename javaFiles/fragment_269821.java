class SubIndex extends AbstractIndex implements AdditionalFunctionalityInterface {

    private class AuxRootIndex extends RootIndex {
        @Override
        void postConstruct() {
            // DON'T do what super.postConstruct() does
            // might as well be empty if you wish
        }
    }

    // composition
    private AuxRootIndex myRootIndex;

    @Override
    void foo() {
        // your stuff

        // a little bit unclear here, you can keep the one from
        // AbstractIndex or the one from RootIndex if you want
        myRootIndex.foo();
    }


    @Override
    public void bar() {
        myRootIndex.bar();
    }
}