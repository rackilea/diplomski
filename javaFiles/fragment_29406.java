public class BitSetWritable implements Writable {

  private BitSet set;

  public BitSetWritable() {
    // default constructor
  }

  public BitSetWritable(BitSet set) {
    this.set = set;
  }
  [...]
}