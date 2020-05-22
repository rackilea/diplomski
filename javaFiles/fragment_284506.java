Map<String, String> resultMap = new HashMap<String, String>();
String[] prefixes = new String[]{"info1", "info2", "info3"};    
String source = "info1 info1ContentA info1ContentB info3 info3ContentA info3ContentB"+" info2 info2ContentA";
String[] parts = source.split(" ");

for(String part : parts) {
    for(String prefix : prefixes) {
        if(part.startsWith(prefix) {
            String currentResult = (resultMap.containsKey(prefix) ? resultMap.get(prefix) + part + " " : part);
            resultMap.put(prefix, currentResult);
        }
    }
}