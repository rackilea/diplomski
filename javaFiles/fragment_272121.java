class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
      String finallyAsString = "finally{ if (session != null && session.isOpen()){session.clear();session.close();}}";
      boolean match = finallyAsString.matches("(.*)if(.*)\\Q!=\\E(.*)null(.*)\\Q&&\\E(.*)\\Q.isOpen()\\E(.*)\\Q.clear()\\E(.*)\\Q.close()\\E(.*)");
      System.out.println(match);
    }
}