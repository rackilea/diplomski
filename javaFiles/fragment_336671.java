//Make a temporary file to save data
        File responseFile = File.createTempFile("SOAP", "xml", context.getFilesDir());      
        int nbCharRead = 0; int i=0; int totalRead = 0;

        //Send query
        OutputStream outputS = url_Connection.getOutputStream();
        Writer w_out = new OutputStreamWriter(outputS);
        w_out.write(webServiceXml);
        w_out.flush();
        w_out.close();


        //Buffers
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(url_Connection.getInputStream()));
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(responseFile));
        char[] buffer = new char[10000];



        while((nbCharRead = bufReader.read(buffer, 0, 10000)) != -1)
        {
            totalRead += nbCharRead;
            Log.d("Test InputStream", "i: " + i++ +" - " + nbCharRead + " -> " + totalRead);
            bufWriter.write(buffer, 0, nbCharRead );
        }       

        if(bufWriter != null)
        {
            bufWriter.flush();
            bufWriter.close();
        }


        Log.w(MsgLog, "--- Stream Got--- ; Total : " + totalRead);