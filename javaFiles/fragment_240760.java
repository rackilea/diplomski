static Printer obj =null;
    private Printer(){}
     public static Printer getInstance(){
         if(obj==null){
             Printer pr=new Printer();
         }
     return obj;  
     }