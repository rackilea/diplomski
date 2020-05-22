// Doing some JDBC Connections here





       Map<String,Connection> connections = new HashMap<>();
        try
        {

           while(DeviceRS.next()){
           try{
           final String ip_address = DeviceRS.getString("Connection_vch");
           connections.put(ip_address,DriverManager.getConnection("jdbc:mysql://" + ip_address + ":3306/test",RemoteUser,RemotePass));
            }
            catch(SQLException ex){
            ex.printStackTrace();

             }
           }  
    catch(Exception ex){

        ex.printStackTrace();
            System.out.println("in catch block");
//System.exit(0); // dont use this -in real time projects
        }finally{
       System.out.println("in finally block");

        } 

            for(final String ip : connections.keySet())
            {

              // Selecting and inserting into database here ...

             }// ENd of for loop

        }// ENd of try block