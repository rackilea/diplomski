//BlueTooth
  String lineRead = "";
  try
  {
    lineRead = new String(sampleSPPServer.readFromDevice());
    if(lineRead != null && !lineRead.isEmpty())
    {
      String lineTransf = lineRead.replace("\n", "").replace("\r", "").replace(" ", "").replace("\"", "").trim();
      println("LineTransf: " + lineTransf + " " + lineTransf.length());
      String lastTry = "";
      for(int i = 0; i < lineTransf.length(); i++)
      {
        if(lineTransf.charAt(i) != ' ' && lineTransf.charAt(i) != '\u0000')
        {
          println(lineTransf.charAt(i));
          lastTry += lineTransf.charAt(i);
        }
      }
      println("LastTry: " + lastTry);
      rotZ += 0.01*(Float.parseFloat(lastTry));
      println("Zrotation: " + rotZ);
    }
    else
      rotZ += 0;
    //System.out.println("Line Read:" + lineRead);
  }
  catch(Exception e)
  {
    println("Exception: " + e);
  }