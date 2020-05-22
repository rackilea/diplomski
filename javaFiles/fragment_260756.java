public class TryHttpV2 extends GenericForwardComposer { 

    public void onUser2$info(Event event) {
        ForwardEvent forwardE = (ForwardEvent) event;
        System.out.println("forwardE.getOrigin().getData(): " + forwardE.getOrigin().getData());
    }
}