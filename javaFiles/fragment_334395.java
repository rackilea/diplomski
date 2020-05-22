public class TestVisitor extends BaseVisitor {
    public TestVisitor(Supplier<Node> g) { super(g.get()); }
}

// ... and then you can do things like

TestVisitor staticVisitor = new TestVisitor(() -> null);
TestVisitor dynamicVisitor = new TestVisitor(() -> new Node());