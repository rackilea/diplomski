Collection<MyElement> interestingElements = getInterestingElements(allElements);
Iterator<MyElement> iterator = interestingElements.iterator();
if (!iterator.hasNext()) {
    return null;
}
MyElement first = iterator.next();
if (iterator.hasNext()) { // More than one element
    return null;
} else {
    return first;
}