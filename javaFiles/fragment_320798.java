if (userName.equals("EXAMPLE")) {


                        //update time when client logged in
                        String Time = "update `clients` set `time`='" + now() + "' where clientid=1 "; 
                        stmt.executeUpdate(Time);

            }