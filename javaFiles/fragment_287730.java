catch(Exception e){
    System.out.println("Error: " + e.getMessage());
}
finally{
    session.close();
} 
return -1;