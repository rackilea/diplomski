try ( Statement st = connection.prepareStatement(sql); )
 {
     // use the statement here ...
     st.executeUpdate();
 }
 catch(Exception e) {
 }
 // st will be closed here


Statement st = null;
try
{
   st = connection.prepareStatement(sql);
}
catch(Exception e) {
}
finally {
    try { 
        if( st != null ) st.close(); 
    } 
    catch (Exception ex) {
         throw new RuntimeException("cannot close statement", ex);
    }
}