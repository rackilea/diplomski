public class CollectDBDataFlow {
@InitiatingFlow
@StartableByRPC
public static class Initiator extends FlowLogic<List<Object>> {
    Party counterparty;

    public Initiator(Party counterparty) {
        this.counterparty = counterparty;
    }

    @Suspendable
    @Override public List<Object> call() {
        // TODO: Implement queryMyDatabase to perform querying.
        Object myDBData = queryMyDatabase();

        FlowSession counterpartySession = initiateFlow(counterparty);
        Object theirDBData = counterpartySession.receive(Object.class);

        return ImmutableList.of(myDBData, theirDBData);
    }
}

@InitiatedBy(Initiator.class)
public static class Responder extends FlowLogic<Void> {
    private FlowSession counterpartySession;

    public Responder(FlowSession counterpartySession) {
        this.counterpartySession = counterpartySession;
    }

    @Suspendable
    @Override
    public Void call() {
        // TODO: Implement queryMyDatabase to perform querying.
        Object myDBData = queryMyDatabase();

        counterpartySession.send(myDBData);

        return null;
    }
}
}