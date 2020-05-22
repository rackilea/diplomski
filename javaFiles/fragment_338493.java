interface IRequired
{
   String doWhatClientNeeds(int x);
}

class Client
{
   public void doTheThing(IRequired target);
}

class Adaptee
{
    public String adapteeMethod(int x);
}

class ClassThatNeedsAdapter
{
    private final Adaptee m_whatIHave;

    public String doThingWithClient(Client client)
    {
       // super easy lambda adapter implements IRequired.doWhatClientNeeds
       client.doTheThing(x -> m_whatIHave.adapteeMethod(x));
    }

    public String doOtherThingWithClient(Client client)
    {
       // method reference implements IRequired.doWhatClientNeeds
       client.doTheThing(this::_complexAdapterMethod);
    }

    private String _complexAdapterMethod(int x)
    {
        ...
    }
}