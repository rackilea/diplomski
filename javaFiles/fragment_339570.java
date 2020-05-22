static Collector<Something, ?, Void> toFile(CloseHandler closeAll) {

    class Acc {

        SomeResource resource; // this is your closeable resource

        Acc() {
            try {
                resource = new SomeResource(...); // create closeable resource
                closeAll.add(this::close);        // this::close is a Runnable
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        void add(Something elem) {
            try {
                // TODO write/send to closeable resource here
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        Acc merge(Acc another) {
            // TODO left as an exercise
        }

        // This is the close handler for this particular closeable resource
        private void close() {
            try {
                // Here we close our closeable resource
                if (resource != null) resource.close();
            } catch (IOException ignored) {
            }
        }
    }
    return Collector.of(Acc::new, Acc::add, Acc::merge, a -> null);
}