public void sendName(String str) 
  {
      BufferedOutputStream bos = null;
      try
      {
          System.out.println("Send: "+str);
          bos = new BufferedOutputStream(s.getOutputStream());
          bos.write(str.getBytes(StandardCharsets.US_ASCII));
          bos.flush();
      } catch (IOException ex) 
      {
      }
      finally
      {
          if(bos!= null)
            bos.close();
      }
}