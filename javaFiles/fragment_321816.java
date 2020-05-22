Iterator<Map.Entry<String, Map<String, String>>> parent = PropertyHolder.entrySet().iterator();
while (parent.hasNext()) {
    Map.Entry<String, Map<String, String>> parentPair = parent.next();
    System.out.println("parentPair.getKey() :   " + parentPair.getKey() + " parentPair.getValue()  :  " + parentPair.getValue());

    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
    while (child.hasNext()) {
        Map.Entry childPair = child.next();
        System.out.println("childPair.getKey() :   " + childPair.getKey() + " childPair.getValue()  :  " + childPair.getValue());

        child.remove(); // avoids a ConcurrentModificationException
    }

}