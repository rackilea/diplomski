protected AutoCloseable fooAction() {
    enableFooResources();
    return new AutoCloseable() {
        @Override
        public void close() throws Exception {
            SurroundingClass.this.disableResources();
        }
    }
  }