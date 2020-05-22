try {
        URL bbg = new URL("http://www.bloomberg.com/markets/economic-calendar/");
        BufferedReader r =  new BufferedReader(new InputStreamReader( bbg.openStream()));
        while( (temp = r.readLine())!= null){
            System.out.println(temp);
        }

    } catch (Exception e){
        e.printStackTrace();
    }