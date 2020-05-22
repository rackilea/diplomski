public class AnotherClass{
    public void someMethod(){
        //create list of models objects e.g. get them from user interface
       ArrayList<Model> models=new ArrayList<>();
       for(int i=0;i<3;i++){
            Model model=new Model();
            model.setId(i);
            model.setAttr("attr"+i);
            models.add(model);
       }
       SomeOtherClass obj=new SomeOtherClass();
       obj.insert(models);
    }
}

public class SomeOtherClass{
   //other code above.....

   //my method that inserts each Model object in database
   //Note: this is sample method , you should do it in optimized way
   // e.g. batch insert
    public void insert(ArrayList<Model> models){

      for(Model myModel:models){
          myModel.save();
      }

   }
   //other code below.....
}