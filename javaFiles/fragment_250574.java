add(browserField);

   try
   {
      String embeddedLinkFrame = readTextFile("frame.html");
      browserField.displayContent(embeddedLinkFrame, "http://localhost");
   }
   catch (Exception e)
   {
      System.out.println(e.getMessage());
   }