public static void performSingleSearch(ReferenceSystem referenceSystem, String searchField, List<String> searchValues, SystemStage systemStage) throws Exception {

    if(!isAvailable(referenceSystem, systemStage)) return;
    Map<String, ReferenceElement> result = new HashMap<>();
    try {
        Class<?> classTemp = referenceSystem.getClazz();
        result = ((ReferenceController) classTemp.newInstance()).searchElements(searchField, searchValues, systemStage);
    } catch (Exception e) { 
        return;
    }
    if(result != null) orderResults(result, referenceSystem);
}