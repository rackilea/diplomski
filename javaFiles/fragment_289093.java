final static Map<Integer, String> formatByIndexMap;
static {
    formatByIndexMap = new HashMap<>();
    formatByIndexMap.put(0, "");
    formatByIndexMap.put(1, "    ");
    formatByIndexMap.put(2, "      ");
    // and so on
    formatByIndexMap.put(9, "----format for 10----");
}

public String getFormattedValue(List<String> dataHeaders, List<String> data){
    String formattedOutValue = null;
    if (dataHeaders != null && data != null && 
            dataHeaders.size() == data.size()) {
        Map<String, Integer> dhm = new HashMap<>();
        for(int i = 0; i < dataHeaders.size(); i++) {
            dhm.put(dataHeaders.get(i), i);
        }
        Integer operationNameIndex = dhm.get("OPERATION_NAME");
        if(operationNameIndex != null) {
            formattedOutValue = data.get(operationNameIndex.intValue()) + 
                    formatByIndexMap.get(operationNameIndex);
        }
    }
    return formattedOutValue;
}