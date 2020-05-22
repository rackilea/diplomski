if (resultList.isEmpty() || resultList.get(0) instanceof Object[]) {
    // Several columns in the result
    List<Object[]> resultList = (List<Object[]>) result;
    // The rest of your current code here
} else {
    // Only one column in the result
    List<Object> resultList = (List<Object>) result;
    ...
}