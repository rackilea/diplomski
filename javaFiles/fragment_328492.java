class CountingItemWriter implements ItemStreamWriter {
  private JdbcBatchItemWriter delegate;
  private int count = 0;
  private final String id;

  CountingItemWriter(String id) {
    this.id = "CountingItemWriter#"+id;
  }

  write(List<?> items) {
    delegate.write(items);
    count += items.size();
  }

  open(ExecutionContext ec) {
    count = getInt(this.id, 0);
  }

  update(ExecutionContext ec) {
    ec.putInt(this.id, count);
  }

  close() {
    // no-op
  }
}