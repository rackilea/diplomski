static List<StringBuilder> removeDuplication(List<StringBuilder> directCallList) {
    HashSet<String> set = new HashSet<String>();
    List<StringBuilder> returnList = new ArrayList<StringBuilder>();
    for(StringBuilder builder : directCallList) {
        if(set.add(builder.toString())
            returnList.add(builder);
    }   
    return returnList;
}