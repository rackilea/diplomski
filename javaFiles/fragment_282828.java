StringBuilder result = new StringBuilder();
    for(String string : collectionOfStrings) {
        result.append(string);
        result.append(",");
    }
    return result.length() > 0 ? result.substring(0, result.length() - 1): "";