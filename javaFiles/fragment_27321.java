public class MyVisitor extends org.eclipse.jdt.core.dom.ASTVisitor {

    public boolean visit(MethodInvocation node) {
        List<?> arguments = node.getArguments();
        // do something with the arguments, etc.
    }
}