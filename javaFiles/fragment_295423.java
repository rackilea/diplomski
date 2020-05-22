public enum Band {
    THE_BEATLES("John","Paul","George","Ringo");
    private final List<String> members;
    public List<String> getMembers(){
        // defensive copy, because the original list is mutable
        return new ArrayList<String>(members);
    }
    private Band(String... members){
        this.members=Arrays.asList(members);
    }
}