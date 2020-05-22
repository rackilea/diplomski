static Stream<String> numberedLines(Path path, Charset cs) throws IOException {
    BufferedReader br = Files.newBufferedReader(path, cs);
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<String>(
            Long.MAX_VALUE, Spliterator.ORDERED|Spliterator.NONNULL) {
        int counter;
        public boolean tryAdvance(Consumer<? super String> action) {
            String line;
            try {
                line = br.readLine();
                if(line==null) return false;
                action.accept("Line " + counter++ + ": " + line.trim());
                return true;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }
    }, true).onClose(()->{ try { br.close(); }
        catch (IOException ex) { throw new UncheckedIOException(ex); }
    });
}