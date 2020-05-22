public String toQueryString() {
    StringBuilder sb = new StringBuilder();
    for (Field field : this.getClass().getDeclaredFields()) {
        if (sb.length() > 0) {
            sb.append("&");
        }

        Class cls = field.getType().getSuperclass();
        // serializing my complex objects - they all inherit from BaseJsonObject class
        if (cls != null && cls.equals(BaseJsonObject.class)) {
            BaseJsonObject bjo = (BaseJsonObject) getFieldValue(field);
            String str = toJson(bjo, true);
            sb.append(field.getName()).append("=").append(Uri.encode(str));
        } 
        // serializing lists, they are all List<T>
        else if (field.getType().equals(List.class)) {
            List bjo = (List) getFieldValue(field);
            String val = toJson(bjo, false);
            sb.append(field.getName()).append("=").append(Uri.encode(val));
        } 
        // serializing simple fields
        else {
            Object bjo = getFieldValue(field);
            String val = toJson(bjo, false).replaceAll("^\"|\"$", "");
            sb.append(field.getName()).append("=").append(Uri.encode(val));
        }
    }

    return sb.toString();
}

private Object getFieldValue(Field field) {
    try {
        return field.get(this);
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }

    return null;
}

private static ObjectMapper generateMapper() {
    ObjectMapper om = new ObjectMapper();
    // om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    om.setDateFormat(new JacksonSimpleDateFormat());

    return om;
}

public String toJson() {
    try {
        return generateMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return null;
    }
}

public String toJson(Object o, boolean noQuoteProperties) {
    try {
        ObjectMapper om = generateMapper();
        if (noQuoteProperties) {                
            om.configure(com.fasterxml.jackson.core.JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
            om.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);           
        }
        return om.writeValueAsString(o);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return null;
    }
}