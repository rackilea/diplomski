public interface UseCaseInputPort {
    public Order findOrderById(Long id);
}

public interface UseCaseOutputPort {
    public void save(Order order);
}