public List<Element> removeDuplicates(List<Element> theList) {
    // Getting a map where key is an id of element and the list is all the elements with the same id
    Map<String, List<Element>> theData = theList.stream().collect(Collectors.groupingBy(elem -> elem.getId()));

    List<Element> result = new ArrayList<>();
    //Now we go over the map and from each list we take the element with newes date
    theData.forEach((id, elementsList) -> {
        Element elementWithNewstDate = getNewest(elementsList);
        result.add(elementWithNewstDate);
    });

    return result;
}

private Element getNewest(List<Element> elementsList) {
    // Sorting by newest date
    elementsList.sort(Comparator.comparing(element -> getDateFromElement(element)));
    //Taking the first one becouse it supose to be the newst if i am wrong take the last element
    return elementsList.get(0);
}

private Date getDateFromElement(Element element) {
    Date result = null;
    try {
        result = new SimpleDateFormat("yyyy-MM-dd").parse(element.getDate());
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return result;
}