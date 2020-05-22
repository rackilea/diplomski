if (fileContent.size() < i + 3 
    && (!fileContent.get(i+1).matches(PATTERN)
        || !fileContent.get(i+2).matches(PATTERN) 
        || !fileContent.get(i+3).matches(PATTERN))) {
        return false;
   }