public void modName() throws IOException{

     PrintWriter outputStream = null;
     outputStream = new PrintWriter("C:\\Users\\OsaMa\\Desktop\\Toyota.txt","UTF-8");
     node n=head;

    while (n != null){
       if(n.Company.equalsIgnoreCase("Toyota")){
          outputStream.println(n.ModelName);
           n=n.next;
       }
       else{
           n=n.next;
       }
        } 
    outputStream.close();

}