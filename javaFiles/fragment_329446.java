protected <E> int compareFields(E o1, E o2, String fieldName){
    try { 
        Comparable o1Data = (Comparable) o1.getClass().getMethod(fieldName).invoke(o1);
        Comparable o2Data = (Comparable) o2.getClass().getMethod(fieldName).invoke(o2);
        return o1Data == null ? o2Data == null ? 0 : 1 :
               o2Data == null ? -1 : o1Data.compareTo(o2Data);
    } catch(Exception e) {
        throw new RuntimeException(e);
    }
}