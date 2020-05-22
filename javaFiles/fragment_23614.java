catch (JMSException e)
{
   System.err.println("getLinkedException()=" + e.getLinkedException());
   System.err.println(e.getLocalizedMessage());
   e.printStackTrace();
}