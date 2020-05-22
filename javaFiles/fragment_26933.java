private List<String> setPropertyFormatter(String key, Object list) {
    List<String> tempProperties = new ArrayList<>();
    Iterator<?> propertyIterator = PropertyConverter.toIterator(list, '\n');;
    String indent = new String(new char[key.length() + 1]).replace('\0', ' ');

    Boolean firstIteration = true;
    while (propertyIterator.hasNext()) {
        String value = propertyIterator.next().toString();

        Boolean lastIteration = !propertyIterator.hasNext();

        if(firstIteration && lastIteration) {
            tempProperties.add(value);
            continue;
        }

        if(firstIteration) {
            tempProperties.add(value + ",\\");
            firstIteration = false;
            continue;
        }

        if (lastIteration) { 
            tempProperties.add(indent + value);
            continue;
        } 

        tempProperties.add(indent + value + ",\\");
    }



    return tempProperties;
}