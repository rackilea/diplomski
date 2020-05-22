public MyClass{

    private final Object lock = new Object();
    private Boolean flag = false;

    public Boolean getflag(){
       synchronized(lock){
          //BLOCK 1
          return flag;
       }
    }

    public void setflag(Boolean flag){
       synchronized(lock){
           //BLOCK 2
           this.flag = flag;
       }
    }
}