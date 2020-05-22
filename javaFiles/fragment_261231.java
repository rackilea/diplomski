public enum Elvis {

    INSTANCE;

    private Object wrappedObject = new Object();


    public Object wrappedObject(){ return wrappedObject; }


    public static void main(String args[]){
        Object sortaSingledton = INSTANCE.wrappedObject();//there still can be only one
    }
}