@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class RemoveTest {

    private static final int NUMBER_OF_LIST_INDEXES = 1_000_000;
    private static final String[] words = "Testing Lamba expressions with this String array".split(" ");

    private ArrayList<String> arrayList;
    private LinkedList<String> linkedList;

    @Setup(Level.Iteration)
    public void setUp() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0 ; i < NUMBER_OF_LIST_INDEXES ; i++){
            arrayList.add(words[i%6]);
            linkedList.add(words[i%6]);
        }
    }

    @Benchmark
    public void removeIfArrayList() {
        arrayList.removeIf(x -> x.contains("s"));
    }

    @Benchmark
    public void removeIfLinkedList() {
        linkedList.removeIf(x -> x.contains("s"));
    }

    @Benchmark
    public void removeIteratorArrayList() {
        for (ListIterator<String> it = arrayList.listIterator(arrayList.size()); it.hasPrevious();){
            if (it.previous().contains("s")) it.remove();
        }
    }

    @Benchmark
    public void removeIteratorLinkedList() {
        for (ListIterator<String> it = linkedList.listIterator(linkedList.size()); it.hasPrevious();){
            if (it.previous().contains("s")) it.remove();
        }
    }

    public static void main(String[] args) throws Exception {
         Main.main(args);
    }

}