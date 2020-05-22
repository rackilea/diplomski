public static String objectDetails(Object o) {
    StringBuilder sb = new StringBuilder(o.getClass().getSimpleName());

    try {
        @SuppressWarnings("unchecked")
        Map<String, Object> objectProperties = BeanUtils.describe(o);
        for (String k : objectProperties.keySet()) {
            sb.append(", " + k + "=\"" + objectProperties.get(k) + "\"");
        }
    } catch (IllegalAccessException e) {
        return "IllegalAccessException attempting to parse object.";
    } catch (InvocationTargetException e) {
        return "InvocationTargetException attempting to parse object.";
    } catch (NoSuchMethodException e) {
        return "NoSuchMethodException attempting to parse object.";
    }

    return sb.toString();
}