@Override
public void write(List<? extends T> items) throws Exception {

    ...
    StringBuilder lines = new StringBuilder();
    int lineCount = 0;
    for (T item : items) {
        lines.append(lineAggregator.aggregate(item) + lineSeparator);
        lineCount++;
    }
    ...
}