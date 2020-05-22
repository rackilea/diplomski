BufferedReader in = new BufferedReader(new InputStreamReader(
                                    conn.getInputStream()));
        String count;
        while ((count = in.readLine()) != null) 
            //this will print the count in count variable
            System.out.println(count);
        in.close();
    }