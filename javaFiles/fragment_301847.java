public boolean hasNumberOfObjectRequired() {
    String type = details.getTypeOfObjectRequired();
    int requiredCount = details.getNumberOfObjectRequired();

    return container.count(type) >= requiredCount;
}