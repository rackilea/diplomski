@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@OperationsPerInvocation(Measure.SIZE)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(1)
public class Measure
{
  static final int SIZE = 4_000_000;
  private Random rnd;

  @Setup public void setup() {
    rnd  = new Random();
  }

  @Benchmark public Object heap() {
    Heap<Integer> heap = new Heap<>();
    for (int i = 0; i < SIZE; i++) heap.insert(rnd.nextInt());
    return heap;
  }

  @Benchmark public Object booksHeap() {
    BooksHeap<Integer> heap = new BooksHeap<>();
    for (int i = 0; i < SIZE; i++) heap.insert(rnd.nextInt());
    return heap;
  }

  public static class Heap<T extends Comparable<? super T>> {

    private T[] array = (T[])new Comparable[10];
    private int size = 0;

    public void insert(T data) {
      if(size+1 > array.length) expandArray();

      array[size++] = data;
      int pos = size-1;
      T temp;

      while(pos != 0 && array[pos].compareTo(array[pos/2]) < 0) {
        temp = array[pos/2];
        array[pos/2] = array[pos];
        array[pos] = temp;
        pos /= 2;
      }
    }

    private void expandArray() {
      T[] newArray = (T[])new Comparable[array.length*2];
      for (int i = 0; i < array.length; i++)
        newArray[i] = array[i];
      array = newArray;
    }
  }

  public static class BooksHeap<AnyType extends Comparable<? super AnyType>>
  {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private AnyType [ ] array;

    public BooksHeap()
    {
      this( DEFAULT_CAPACITY );
    }

    public BooksHeap( int capacity )
    {
      currentSize = 0;
      array = (AnyType[]) new Comparable[ capacity + 1 ];
    }

    public void insert( AnyType x )
    {
      if( currentSize == array.length - 1 )
        enlargeArray( array.length * 2 + 1 );

      int hole = ++currentSize;
      for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
        array[ hole ] = array[ hole / 2 ];
      array[ hole ] = x;
    }


    private void enlargeArray( int newSize )
    {
      AnyType [] old = array;
      array = (AnyType []) new Comparable[ newSize ];
      for( int i = 0; i < old.length; i++ )
        array[ i ] = old[ i ];
    }
  }
}