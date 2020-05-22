class RewriterSpec {
    private final Rewriter rewriter;
    private final List<Mapping> mappings;

    public RewriterSpec(Rewriter rewriter) {
        this.rewriter = rewriter;
        this.mappings = rewriter.getMappings();
    }

    public addMapping(Mapping m) {
        mappings.addMapping(m);
    }
}