int anInt= -1;
  try{
   anInt = Integer.parseInt(content);
  }
  catch (NumberFormatException e)
  {
    //Show toast or dialog
  }