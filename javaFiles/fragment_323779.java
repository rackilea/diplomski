public class ProcDaoImpl{

    public void executeProc(){

         ParamHolder[] paramArray = new ParamHolder[]{                                          //create an array of four elements
                                      new ParamHolder("param1","param2","param3"),
                                      new ParamHolder("param1","param2","param3"),
                                      new ParamHolder("param1","param2","param3"),            
                                      new ParamHolder("param1","param2","param3")                                                   //Each array element represents a set of InputParams
                                   }

     //call the DB procedure now..
     SomeClass.callProc(paramArray);                                                                     // pass in the created array to it.
    }

}