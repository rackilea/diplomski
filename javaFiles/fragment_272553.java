while (!Thread.currentThread().isInterrupted()) 
        {                   
            String req = rep.recvStr(0);
            rep.send(req + " response");

            pub.sendMore("Message header");
            pub.send("Message body");;          
        }