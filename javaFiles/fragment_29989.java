import java.util.Comparable;

public class BlockOffset implements Comparable<BlockOffset>
{
  private int blockNumber;
  private int offset;

  @Override
  public int compareTo(BlockOffset instance2) {
    if (this.blockNumber < instance2.blockNumber) return -1;
    if (this.blockNumber > instance2.blockNumber) return 1;
    if (this.offset < instance2.offset) return -1;
    if (this.offset > instance2.offset) return 1;

    return 0;
  }   
}