interface IRequired
{
   String clientNeed1(int x);
   int clientNeed2(String x);
}

class Client
{
   public void doTheThing(IRequired target);
}


class ClassThatNeedsAdapter
{
    private final Adaptee m_whatIHave;

    public String doThingWithClient(Client client)
    {
       IRequired adapter = new IRequired() {
           public String clientNeed1(int x) {
               return m_whatIHave.whatever(x);
           }
           public int clientNeed2(String x) {
               return m_whatIHave.whateverElse(x);
           }
       };
       return client.doTheThing(adapter);
    }
}