public static void main(String[] args) throws Exception {
    Method method = sun.security.ec.CurveDB.class.getDeclaredMethod("getSupportedCurves", null);
    method.setAccessible(true);
    Collection result = (Collection) method.invoke(null, null);
    for (Object object : result) {
        System.out.println(object);
    }
}