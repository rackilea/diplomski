private void saveToCSV(String url) {
    BufferedWriter writer = getBufferedWriter(url);
    writer.write(ReportItem.getHeaders() + "\r\n");
    reportItems.forDate(dt)
               .map(ReportItem::toCSVLine).map(s -> s.concat("\r\n"))
               .finallyDo(() -> close(writer))
               .subscribe(Checked.a1(writer::write), Throwable::printStackTrace);
}

private void close(BufferedWriter writer) {
    try {
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private BufferedWriter getBufferedWriter(String url) {
    try {
        File outputFile = new File(url);
        return new BufferedWriter(new FileWriter(outputFile));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}