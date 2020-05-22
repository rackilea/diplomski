StringBuilder hashmapDetails = new StringBuilder();
for(Map.Entry<String, String> e : mappings.entrySet()) {
    String[] details = e.getKey().split("/");
    hashmapDetails += details[1];
    hashmapDetails += e.getValue();
    hashmapDetails += ";";
}

String result = hashmapDetails.substring(0, hashmapDetails.length() - 1);