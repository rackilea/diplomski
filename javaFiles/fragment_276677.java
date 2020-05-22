File f=new File("C:/Users/Junaid Hassan/Contacts",FINAL1);

    FileReader fr=new FileReader(f); 
    BufferedReader br=new BufferedReader(fr);
    String key;
    while((key=br.readLine())!=null)    //then you have to split the strings 

    String SPLIT[]=NAME.split(",");
            String Login=SPLIT[0];
                String Name=SPLIT[1];
                    String Address=SPLIT[2];
                        String Contact=SPLIT[3];
//then put a check that if your login will match a key
if(Login.equals(key)){
   //here do what you want change the address
}
   }