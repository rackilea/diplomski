String xmlContent = response.toString();
String value = xmlContent.replaceFirst("(?sm)^.*<string[^>]*>([^<]*)<.*$", "$1");

if (value == xmlContent) { // No replace
    throw new IllegalStateException("Not found");
}
boolean result = Boolean.valueOf(value.trim().toLowerCase());