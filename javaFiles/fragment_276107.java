public void exportAsCsv(CqlQuery query, Writer writer) {
    Iterator<String> result = queryService.execute(.....);
    for (String nextLine : result) {
        writer.append(nextLine);
    }
}