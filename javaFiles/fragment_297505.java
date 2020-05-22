class Demo extends RealmObject{
    public Demo() {
        id = UUID.randomUuid().toString();
        isVisible = true;
    } 

    @PrimaryKey
    private String id; // I want to set this id to a uuid 
    private boolean isVisibile; // set this to default as true              
}