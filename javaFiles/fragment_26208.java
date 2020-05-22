public class RPCServer implements RPCServerInterface{
  private int row;
  private Map<String,Integer> countByMethod = new HashMap<String,Integer>();

  // +1 to the number of time of execution of this method
  private void sumMethodInvocation(String method) {
   if ( countByMethod.containsKey(method) ) {
     int n = countByMethod.get(method);
     countByMethod.put(method, n+1);
   } else {
     countByMethod.put(method,1);
   }
  }

  // how many time the method has been invoked 
  @Override
  public int countMethodInvocation(String method){
    return countByMethod.containsKey(method)?countByMethod.get(method):0;
  }

  public void setRow(int i) { 
    // register each time is executed
    this.sumMethodInvocation("setRow"); 
    this.row = i;
  }
  public int getRow() {
    // register each time is executed
    this.sumMethodInvocation("getRow");
    return row;
  }
}}
}