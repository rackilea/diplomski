boolean check=true;
while(check) {
    Socket s = null;
    try {
        s = new Socket(host, port);
        check=false;
    } catch(ConnectionException e) {
        System.out.println("trying again...");
        try
        {
            Thread.sleep(2000);// waiting 2 seconds before next try
        }
        catch(InterruptedException ie){
        }
    } finally {
        if(s != null) {
            try {
                s.close();
            }
            catch(Exception e) {
            }
        }
    }
}