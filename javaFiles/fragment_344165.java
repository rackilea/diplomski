class MyInfo{
    static void showStack(){
        try{
            throw new Exception();
        }catch(Exception e){
            StackTraceElement[] ste=e.getStackTrace();
            for(int i=1; i<ste.length;i++){
                System.out.println(ste[i].getClassName()+"."+ste[i].getMethodName());
            }
        }
    }
}