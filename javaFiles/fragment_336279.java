class ClassName{
    private ImmutableSet<String> set;

    public ClassName(Set<String> set){
        this.set= ImmutableSet.copyOf(set);
    }

    public ImmutableSet<String> getSet(){
        return set;
    }
}