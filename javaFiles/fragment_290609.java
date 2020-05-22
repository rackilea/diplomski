public Map<String,ExtractedData> getExtractedData(String name)
{
    return extractedDatas.entrySet().stream()
            .filter(entry -> entry.getKey().startsWith(name))
            .filter(entry -> entry.getValue().getFieldValue() != null && entry.getValue().getFieldValue() != "")
            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
}