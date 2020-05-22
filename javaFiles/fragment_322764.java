CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
Map<String, Integer> headerMap = parser.getHeaderMap();

int header1Index = -1;
int header2Index = -1;
for (Map.Entry<String, Integer> entry : headerMap.entrySet()) {
    String name = entry.getKey();
    int index = entry.getValue();

    switch (name.trim()) {
    case "Header1":
        header1Index = index;
        break;
    case "Header2":
        header2Index = index;
        break;
    }
}

for (CSVRecord record : parser) {
    ...
    mo.setHeader1(record.get(header1Index));
    ...
}