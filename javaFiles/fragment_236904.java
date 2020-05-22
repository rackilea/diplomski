public interface DataItemVisitor {
  // one method for each subtype you want to handle
  void process(ChildDataItemA item);
  void process(ChildDataItemB item);
}

public class PersistenceService implements DataItemVisitor { ... }
public class RenderService implements DataItemVisitor { ... }