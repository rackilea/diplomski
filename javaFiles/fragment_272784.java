public enum ExecutionMode {
  TYPE_A(x,t),
  TYPE_B(y,z),
  TYPE_C(b,s)

  private boolean incremental; //has get/set
  private String someStr;      //has get/set

  ExecutionMode(boolean incremental,String someStr){
        ///... set things appropriately
  } 
}