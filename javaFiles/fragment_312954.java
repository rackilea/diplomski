public void servicesDiscovered(int transID, ServiceRecord serviceRecord[])
    {
        String url = serviceRecord[0].getConnectionURL(1, false);
try
        {
            //ClientSession conn= (ClientSession)Connector.open(url);
            StreamConnection meineVerbindung = (StreamConnection) Connector.open(url);

            if(conn== null)
                System.out.println("Kann Service URL nicht oeffnen\n");
            else
            {

                OutputStream out = conn.openOutputStream();
                InputStream in = conn.openInputStream();

                String message = "AT+CGMI\r\n";

                // send AT-command
                System.out.println("send AT Comand request: "+message);
                out.write(message.getBytes());

                out.flush();
                out.close();

                byte buffer[] = new byte[10000];
                // read the response from mobile phone
                in.read(buffer);
                System.out.println("AT Comand response: "+buffer.toString());}            

        }
        catch(IOException e)
        {
            System.out.println("Service Error(3): "+e.getMessage());
        }

    }