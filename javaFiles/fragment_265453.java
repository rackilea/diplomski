public static <T extends Animal> Map<String, List<T>> 
         groupAnimalsByOwner(List<? extends T> animals)
{
    Map<String, List<T>> groupedMap = new HashMap<String, List<T>>();
    List<T> tempList = null;

    for (T summary : animals) {
        String consolidatedInvoiceId = summary.getOwner();
        tempList = groupedMap.get(consolidatedInvoiceId);
        if (tempList == null) {
            tempList = new LinkedList<T>();
        }
        tempList.add(summary);
        groupedMap.put(consolidatedInvoiceId, tempList);
    }

    return groupedMap;
}