private String cachedProperties = null;
public String displayProperties() {
    if (cachedProperties == null) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < properties.size(); i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(properties.get(i));
        }
        cachedProperties = sb.toString();
    }   
    return cachedProperties;
}