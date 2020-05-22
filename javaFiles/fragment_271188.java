class RewriterSpec {
    private final Rewriter rewriter;

    public RewriterSpec(Rewriter rewriter) {
        this.rewriter = rewriter;
    }

    public addMapping(Mapping m) {
        rewriter.addMapping(m);
    }
}