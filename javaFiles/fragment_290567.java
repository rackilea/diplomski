class Demo {
    public static void main(String args[]){
        RunnableA a1=new RunnableA();
        new Thread(a1).start(); 
    }
}