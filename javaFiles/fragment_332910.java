class YourDeepCloneClass implements DeepCloneable {

    @Override
    public Object deepClone() {
        // logic to do deep-clone
        return new YourDeepCloneClass();
    }

}