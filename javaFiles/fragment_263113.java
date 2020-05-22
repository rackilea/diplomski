for(String arrayElement : comp) {
    if(!compMap.containsKey(arrayElement)) {
        compMap.put(arrayElement, 1);
    } else {
        int newCount = compMap.get(arrayElement) + 1;
        compMap.put(arrayElement, newCount);
    }
}