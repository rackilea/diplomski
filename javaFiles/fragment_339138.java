try
    {
        FileInputStream fin = new FileInputStream(mypdffile);


        int read=0;
        byte[] buf=new byte[1024];

        //read in file 
        while((read=fis.read(buf))>0) {

            dos.write(buffer,0,read);
                    dos.flush();

        }
    dos.close();



    }
    catch(IOException ex)
    {
        ex.printStackTrace();

    }