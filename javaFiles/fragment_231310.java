BufferedReader br = null       ;
                   BufferedWriter out = null;
    try{

        InputStream is = new FileInputStream(new File("C:/Space/ConnTest/Test/input.txt"));
         br = new BufferedReader(new InputStreamReader(is));
         out = new BufferedWriter(new FileWriter(new File("C:/Space/ConnTest/Test/output.txt")));
        System.out.println("This is first line ---"+br.readLine());
        String str = "";
        while ((str = br.readLine()) != null) {
            out.write(str);
        }
        System.out.println("Success");




    }
    catch(Exception e )
    {
        e.printStackTrace();
    }
    finally
    {
        if(br!=null)
        {
            br.close();
        }
        if(out!=null)
        {
            out.close();
        }
    }