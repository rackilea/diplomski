public void insertARow(PreparedStatement ps, ArrayList<String> row){
 //your code
}

public void calledMethod(){
 String insert = "INSERT INTO user.info(cola,colb) values(?,?)";
 PreparedStatement ps = null;

 try{
   ps = con.prepareStatement(insert);
   /**
    * Here you make the call to insertARow passing it the preparedstatement that you
    * have created. This in your case will be called multiple times.
    */
   insertARow(ps, row);
 }finally{
   if(ps != null){
     //close ps
   }
 }
}