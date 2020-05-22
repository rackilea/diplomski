class TabDataCellJsonSerializer implements JsonSerializer<TabDataCell> {
    @Override
    public JsonElement serialize(TabDataCell src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getCellValue());
    }
}