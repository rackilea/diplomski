public class ObjV1 implements SomeObject(){ // objects would simply extend interface
    ...
}

public class SomeObjectFactory{// factory would provide construction methods for different implementations of the interface

   //Hide factory constructor, so we use it only as a singleton
   private SomeObjectFactory(){
   }

   public static ObjV1 buildV1(String str){
      ObjV1 obj = new ObjV1(); // note that we're using the noarg constructor
      ...
      return obj;
   }
}