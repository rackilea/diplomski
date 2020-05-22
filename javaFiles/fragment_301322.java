public abstract class Logic
{
    public static readonly Logic PayDay = new PayDayImpl();
    public static readonly Logic CollectCash = new CollectCashImpl();
    public static readonly Logic EtcEtc = new EtcEtcImpl();

    // Prevent other classes from subclassing
    private Logic() {}

    public abstract void AcceptPlayer(Player player);

    private class PayDayImpl : Logic
    {
        public override void AcceptPlayer(Player player)
        {
            // Perform logic
        }
    }

    private class CollectCashImpl : Logic
    {
        public override void AcceptPlayer(Player player)
        {
            // Perform logic
        }
    }

    private class EtcEtcImpl : Logic
    {
        public override void AcceptPlayer(Player player)
        {
            // Perform logic
        }
    }
}