static Printer obj = null;
private Printer(){}

public static Printer getInstance(){
 if(obj == null){
  obj = new Printer();
 }
 return obj;
}