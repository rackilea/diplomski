@Service
public class MyServiceImpl implements MyService {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public int increment() {
        return COUNTER.getAndIncrement();
    }
}