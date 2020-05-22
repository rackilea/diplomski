FileWriter writer = null;
String text = "username";
try{
     writer = new FileWriter("banned.txt", true);
     writer.write("\r\n"); 
     writer.write(text,0,text.length());
}catch(IOException ex){
    ex.printStackTrace();
}finally{
  if(writer != null){
     writer.close();
  }
}