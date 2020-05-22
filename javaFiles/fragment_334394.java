public interface NodeGenerator {  Node generate(); }
public class StaticGenerator implements NodeGenerator { 
    public Node generate() { return null; }
}
public class DynamicGenerator implements NodeGenerator {
    public Node generate() { return new Node(); }
}

public class TestVisitor extends BaseVisitor {
     public TestVisitor(NodeGenerator g) { super(g.generate()); }
}