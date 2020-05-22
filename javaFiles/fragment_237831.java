public static <T> void nicePrint(final Collection<T> collection,
                                     final PrintStream printStream,
                                     final Optional<String> delimiter) {
        final Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            printStream.print(iterator.next());
            if (iterator.hasNext()) {
                delimiter.ifPresent(printStream::print);
            }
        }
    }