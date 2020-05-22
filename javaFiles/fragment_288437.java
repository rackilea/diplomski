public abstract class DataType {
  public abstract <T> T accept(Operator<T> op);
}

public interface Operator<T> {
  T operateAlpha(DataTypeAlpha data);
  T operateBeta(DataTypeBeta data);
  ...
}

public class DataTypeAlpha extends DataType {
  public <T> T accept(Operator<T> op) {
    return op.operateAlpha(this);
  }
}
....