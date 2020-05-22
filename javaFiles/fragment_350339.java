while(true){                
            SSLSocket sslsocket = (SSLSocket) s.accept();
            System.out.println("New Client accepted");
            TestThread t = new TestThread(sslsocket);
            t.run();      
        }