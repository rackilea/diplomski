BufferedReader  buffered_reader=null;
    try 
    {
        //InputStream istream = Runtime.getRuntime().exec("cat /sys/kernel/abb-chargalg/eoc_status").getInputStream();
        //InputStreamReader istream_reader = new InputStreamReader(istream);
        //buffered_reader = new BufferedReader(istream_reader);
        buffered_reader = new BufferedReader(new FileReader("/sys/kernel/abb-chargalg/eoc_status"));
        String line;

        while ((line = buffered_reader.readLine()) != null) 
        {
            System.out.println(line);
        }           
    } 
    catch (IOException e) 
    {
        // TODO 
        e.printStackTrace();
    }
    finally 
    {
        try 
        {
            if (buffered_reader != null)
                buffered_reader.close();
        } 
        catch (IOException ex) 
        {
            // TODO 
            ex.printStackTrace();
        }
    }