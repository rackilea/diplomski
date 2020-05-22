for(int builderIndex = 0; builderIndex < indexList.size(); builderIndex++) {
    List<String> test = null;
    if(builderIndex == indexList.size() - 1) {
        test = list.subList(indexList.get(builderIndex), list.size());
    } else {
        test = list.subList(indexList.get(builderIndex), indexList.get(builderIndex + 1));
    }
    System.out.println(test);
}