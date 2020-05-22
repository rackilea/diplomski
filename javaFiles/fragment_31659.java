public final class TsvProcessor extends AbstractIterator<List<String>> {

    private final Splitter splitter = Splitter.on('\t');
    private final Scanner s;

    public TsvProcessor(final File file, final String charset) throws FileNotFoundException {
        s = new Scanner(file, charset);
    }

    @Override
    protected List<String> computeNext() {
        if (!s.hasNext()) {
            s.close();
            return endOfData();
        }
        return splitter.splitToList(s.nextLine());
    }
}