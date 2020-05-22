try {
    BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    int count = 1;

        do { 
            if (rd.ready()){
                System.out.println ("Response Ready");
                str = new Scanner(rd).useDelimiter(">").next()+">";
                count = 501;
            }
            Thread.sleep(10);
            System.out.println ("Response Not Ready" + count);
            count ++;
        } while (count < 25);