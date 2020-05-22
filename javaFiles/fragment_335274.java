List<?> list;
final String attribute = "Name"; // for example. Also, this is case-sensitive
Collections.sort(list, new Comparator<Object>() {
    public int compare(Object o1, Object o2) {
        try {
            Method m = o1.getClass().getMethod("get" + attribute);
            // Assume String type. If different, you must handle each type
            String s1 = (String) m.invoke(o1);
            String s2 = (String) m.invoke(o2);
            return s1.compareTo(s2);
        // simply re-throw checked exceptions wrapped in an unchecked exception
        } catch (SecurityException e) {
            throw new RuntimeException(e); 
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
});