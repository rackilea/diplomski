class ClassName{
    private Set<String> set;

    public ClassName(Set<String> set){
        this.set= new HashSet<>(set);
    }

    public Set<String> getSet(){
        return Collections.unmodifiableSet(set);
    }
}