for (Object[] obj : matrix) {
    Integer currentInteger = (Integer) obj[0];
    String currentDescription = (String) obj[1];
    if (stringToCompare.equals(currentDescription)) {
        return currentInteger;
    }
}