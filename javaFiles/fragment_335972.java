// Server
   try
   {
       Socket clientSocket=new Socket("Some IP",12345);
       OutputStream out=clientSocket.getOutputStream();
       FileInputStream fis=new FileInputStream(file);
       byte[] info = new byte[64];
       int len = file.getPath().length();
       info = file.getPath().getBytes();
       for (int i=len; i < 64; i++) info[i]=0x00;
       out.write(info, 0, 64);
       len = file.getName().length();
       info = file.getName().getBytes();
       for (int i=len; i < 64; i++) info[i]=0x00;
       out.write(info, 0, 64);

       int x;
       byte[] b = new byte[4194304];
       while((x=fis.read(b)) > 0)
       {
         out.write(b, 0, x);
       }
      out.close();
      fis.close();
  }
  catch (Exception e)
  {
      e.printStackTrace();
  }

  // Client
  try
  {
      InputStream in = client.getInputStream();
      FileOutputStream fos = new FileOutputStream("rec.txt");
      byte[] path = new byte[64];
      in.read(path, 0, 64);
      byte[] name = new byte[64];
      in.read(name, 0, 64);

      int x=0;
      byte[] b = new byte[4194304];
      while((x = in.read(b)) > 0)
      {
          fos.write(b, 0, x);
      }
      fos.close();
  }
  catch(Exception e)
  {
     e.printStackTrace();
  }