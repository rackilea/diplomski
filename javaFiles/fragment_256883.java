abstract class SuperClass{
   public abstract Result getResult();
}

class SubClass1 extends SuperClass{
   @Override
   public Result getResult(){
      //logic
   }
}


class SubClass2 extends SuperClass{
   @Override
   public Result getResult(){
      //logic
   }
}

//calling 

getResult(SuperClass request){
   Result r = request.getResult();
}