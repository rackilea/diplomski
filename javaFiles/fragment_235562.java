public MainClass(){
    super();
    synchronized(MainClass.class){
        if(instance != null) throw new UnsupportedOperationException(
                getClass()+" is singleton but constructor called more than once");
        instance = this;
    }
}