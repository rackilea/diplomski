public abstract class DataItem {
  public abstract void accept(DataItemVisitor visitor);
}

public class ChildDataItemA extends DataItem {
  @Override
  public void accept(DataItemVisitor visitor) {
    visitor.process(this);
  }
}

public class ChildDataItemB extends DataItem {
  @Override
  public void accept(DataItemVisitor visitor) {
    visitor.process(this);
  }
}