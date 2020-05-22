private boolean isNotYetGenerated(String box, String color, 
                                  Set<String> generationHistory) {
    String key = box + "=" + color;
    boolean notYetGenerated = ! generationHistory.contains(key);
    if(notYetGenerated) {
        generationHistory.add(key);
    }
    return notYetGenerated;
}