public ReferenceRangeBuilder(Class<T> claz) {
    try {
        lowerReferenceRange = claz.newInstance();
        upperReferenceRange = claz.newInstance();
    } catch (InstantiationException ex) {
        Logger.getLogger(ReferenceRangeBuilder.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(ReferenceRangeBuilder.class.getName()).log(Level.SEVERE, null, ex);
    }
}