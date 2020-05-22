public interface DataFiller<T extends Container> {
    void fillContainer(Object param1, Object param2, T container);
}

public class InOrderDataFiller implements DataFiller<InOrderContainer> {
    @Override
    public void fillContainer(Object param1, Object param2, InOrderContainer container) {
        container.setContent1(param1);
        container.setContent2(param2);
    }
}

public class ReverseDataFiller implements DataFiller<ReverseContainer> {
    @Override
    public void fillContainer(Object param1, Object param2, ReverseContainercontainer container) {
        container.setContent1(param2);
        container.setContent2(param1);
    }
}