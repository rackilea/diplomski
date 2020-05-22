Enumeration<?> e = getServletContext().getAttributeNames();
while (e.hasMoreElements())
{
    String name = (String) e.nextElement();

    // Get the value of the attribute
    Object value = getServletContext().getAttribute(name);

    if (value instanceof Map) {
        for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    } else if (value instanceof List) {
        for (Object element : (List)value) {
            System.out.println(element);
        }
    }
}