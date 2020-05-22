public class Processor implements ItemProcessor<A, A> {

    @Override
    public A process(A i) throws Exception {
        System.out.println("Processing..." + i);
        i.setId("123");
        i.setStatus("Active");
        return i;
    }
}