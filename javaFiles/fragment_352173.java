Fork(1)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 10)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
public class ByteBufProcessorBenchmark {
  private static interface ByteProcessor {
    boolean process(byte value);
  }

  private static final int DATA_SIZE = 1024 * 1024;
  private byte[] data;

  @Setup(Level.Trial)
  public void setUp() {
    data = new byte[DATA_SIZE];
    Random random = new Random();
    random.nextBytes(data);
  }

  @Benchmark
  public void crFirst(Blackhole blackhole) {
    ByteProcessor byteProcessor = new ByteProcessor() {
      private byte previousByte;
      @Override
      public boolean process(byte value) {
        if(previousByte == '\r'){
          if(value == '\n'){
            return false;
          }
        }

        previousByte = value;
        return true;
      }
    };

    doProcess(byteProcessor, blackhole);
  }

  @Benchmark
  public void lfFirst(Blackhole blackhole) {
    ByteProcessor byteProcessor = new ByteProcessor() {
      private byte previousByte;
      @Override
      public boolean process(byte value) {
        if (value == '\n') {
          if(previousByte == '\r'){
            return false;
          }
        }

        previousByte = value;
        return true;
      }
    };

    doProcess(byteProcessor, blackhole);
  }

  @Benchmark
  public void crFirstUpdateCacheOnDemand(Blackhole blackhole) {
    ByteProcessor byteProcessor = new ByteProcessor() {
      private byte previousByte;
      @Override
      public boolean process(byte value) {
        if(previousByte == '\r'){
          if(value == '\n'){
            return false;
          }
          previousByte = 0;
        }else if(value == '\r'){
          previousByte = value;
        }
        return true;
      }
    };

    doProcess(byteProcessor, blackhole);
  }

  @Benchmark
  public void lfFirstUpdateCacheOnDemand(Blackhole blackhole) {
    ByteProcessor byteProcessor = new ByteProcessor() {
      private byte previousByte;
      @Override
      public boolean process(byte value) {
        if (value == '\n') {
          if(previousByte == '\r'){
            return false;
          }
          previousByte = 0;
        }else if(value == '\r'){
          previousByte = value;
        }
        return true;
      }
    };

    doProcess(byteProcessor, blackhole);
  }



@Benchmark
  public void consume(Blackhole blackhole){
    for(int i = 0; i < data.length; i++){
      blackhole.consume(data[i]);
    }
  }


  private void doProcess(ByteProcessor byteProcessor, Blackhole blackhole){
    for(int i = 0; i < data.length; i++){
      blackhole.consume(byteProcessor.process(data[i]));
    }
  }

}