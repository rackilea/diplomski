public class MyEventHandler implements SequenceReportingEventHandler<Element> {
    Sequence processedSequence;

    public void setSequenceCallback(Sequence s) {
        processedSequence = s;
    }

    public void onEvent(Element e, long sequence, boolean endOfBatch) {
        // Do stuff
        processedSequence.set(sequence);
    }
}