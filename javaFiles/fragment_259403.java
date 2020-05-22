class trash {
    protected <T> List<T[]> getYserieRescaledList(Class<T> cl) {
       List<T[]> result = null;
       if (cl instanceof Class<Double>) {
               result = ...;
       } else if (cl instanceof Class<double>) {
               result = ...;
       }
       return result;
    }
}