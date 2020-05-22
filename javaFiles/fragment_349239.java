private boolean isEmpty(CSVRecord csvRecord){
        if (null == csvRecord) return true;
        for (int i = 0; i < csvRecord.size(); i++) {
            if (StringUtils.isNotBlank(csvRecord.get(i))) {
                return false;
            }
        }
        return true;
    }


    public List<Map<String, Object>> getMapFromCSV(InputStream inputStream) {
        try {
            CSVParser parser = parseCSV(inputStream);
            return getMap(parser.getRecords().stream()
                    .sequential().filter(v -> !isEmpty(v))
                    .collect(Collectors.toList()), parser.getHeaderMap());
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

  private List<Map<String, Object>> getMap (List<CSVRecord> records, Map<String, Integer> headers) {
        Map<Integer, String> headerMap = formatHeaderMap(headers);
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 1; i < records.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            try {
                CSVRecord record = records.get(i);
                for (int j = 0; j < record.size(); j++) {
                    map.put(headerMap.get(j), record.get(j));
                }
                data.add(map);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        return data;
    }


 private Map<Integer, String> formatHeaderMap(Map<String, Integer> map) {
        Map<Integer, String> data = new HashMap<>();
        map.forEach((k , v) -> data.put(v, inputSanitizerForUtf8(k)));
        return data;
    }