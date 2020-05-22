public class SubClassA extends SuperClassA
{
    private static Boolean m_firmwareUnpacked = false;

    @Override
    public boolean isValid(){
      return m_firmwareUnpacked;
    }


    @Override
    protected void setValid(boolean b){
       m_firmwareUnpacked = b;
    }

}