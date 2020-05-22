for (Map.Entry < String, String > entry: newList.entrySet()) {
    String getAfterDot = entry.getKey();
    int lastIndxDot = getAfterDot.lastIndexOf('.');
    if (lastIndxDot != -1) {
        String beforeDot = getAfterDot.substring(0, lastIndxDot);
        System.out.println(beforeDot);
    }
}