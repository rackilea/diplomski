public static boolean contains(String value, String[] array) {
    for (String element : array) { // For each element in array
        if (element.equals(value)) { // If we have found the matching element -> return true (we don't need to keep looking)
            return false;
        }
    }
    return false; // No match was found -> return false
}