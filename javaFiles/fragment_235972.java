public static void main(String[] args){
    try{
        doStuff();
    }
    catch(Throwable t){
        StackTraceElement[] elements = t.getStackTrace();
        for(int i = 0; i < 5; i++){
            System.err.println(elements[i]);
        }
    }
}