private static String toCSV(List<Map<String, Object>> list) {
    List<String> headers = list.stream().flatMap(map -> map.keySet().stream()).distinct().collect(toList());
    final StringBuffer sb = new StringBuffer();
    for (int i = 0; i < headers.size(); i++) {
        sb.append(headers.get(i));
        sb.append(i == headers.size()-1 ? "\n" : ",");
    }
    for (Map<String, Object> map : list) {
        for (int i = 0; i < headers.size(); i++) {
            sb.append(map.get(headers.get(i)));
            sb.append(i == headers.size()-1 ? "\n" : ",");
        }
    }
    return sb.toString();
}