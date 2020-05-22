static class ItemResult(){
    public final String item;
    public final Optional<String> result;

    public ItemResult(String item, Optional<String> result){
        this.item = item;
        this.result = result;
    }

    public boolean isPresent(){
        return this.result.isPresent();
    }

    public String getResult(){
        return result.get();
    }
}