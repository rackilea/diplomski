class num1{
    public static final num1 one= new num1("one");

    private String name;
    private num1(String name) {
        this.name = name;
    }

    @Override  //Be sure to add the override annotation here!
    public String toString(){
        return name;
    }   
}