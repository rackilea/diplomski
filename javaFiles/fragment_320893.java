public class LineNumberTextifier extends Textifier {
    private final LineNumberTextifier root;
    private boolean selfCall;
    public LineNumberTextifier() { super(ASM5); root = this; }
    private LineNumberTextifier(LineNumberTextifier root) { super(ASM5); this.root = root; }
    int currentLineNumber() { return count(super.text)+1; }
    private static int count(List<?> text) {
        int no = 0;
        for(Object o: text)
            if(o instanceof List) no+=count((List<?>)o);
            else {
                String s = (String)o;
                for(int ix=s.indexOf('\n'); ix>=0; ix=s.indexOf('\n', ix+1)) no++;
            }
        return no;
    }
    void updateLineInfo(MethodVisitor target) {
        selfCall = true;
        Label l = new Label();
        target.visitLabel(l);
        target.visitLineNumber(currentLineNumber(), l);
        selfCall = false;
    }
    // do not generate source for our own artifacts
    @Override public void visitLabel(Label label) {
        if(!root.selfCall) super.visitLabel(label);
    }
    @Override public void visitLineNumber(int line, Label start) {}
    @Override public void visitSource(String file, String debug) {}
    @Override protected Textifier createTextifier() {
        return new LineNumberTextifier(root);
    }
}