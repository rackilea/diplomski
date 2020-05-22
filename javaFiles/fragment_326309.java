class IDGenerator{
    char c ='A';
    int next = 1;
    public String getNextID(){
        String id = Character.toString(c) + Integer.toString(next++);
        if(next>9){
           next =1;
           c++;
        }
        return id;
    }

}