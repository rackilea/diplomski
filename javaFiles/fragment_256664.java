try{
  try
  {
     f1();
  }
  catch(IndexOutOfBoundsException e)
  {
     System.out.println("A");
     throw new NullPointerException(); //Line 0
  }
}
catch(NullPointerException e) //Line 1
{
     System.out.println("B");
     return;
}