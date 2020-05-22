public Object findDataEntry(Map<String, Object> map, String path)
{
    Object obj;
    while ((obj = map.remove(path)) != null) {
        if (obj instanceof Map) {
            map = (Map<String, Object>) obj;
        } else {
            break;
        }
    }
    return obj;
}