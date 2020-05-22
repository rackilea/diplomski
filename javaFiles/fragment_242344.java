class myObj {

    private String identifier;

    public myObj(String identifier){
        this.identifier = identifier;
    }

    public int hashCode(){
        return identifier.hashCode();
    }

    public boolean equals(Object o){
        return identifier.equals(((myObj)o).identifier);
    }
}