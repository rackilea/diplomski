class JoinedCompressionStrategy implements CompressionStrategy {

    private final CompressionStrategy s0;
    private final CompressionStrategy s1;

    public JoinedCompressionStrategy(CompressionStrategy s0, CompressionStrategy s1) {
        this.s0 = s0;
        this.s1 = s1;
    }

    public File compressFiles(ArrayList<File> files) {
        File archive = s0.compressFiles(files);
        return s1.compressFiles(Arrays.asList(archive));
    }
}