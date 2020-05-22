String replaceCustomDuplicates(String str) {
    if (str.indexOf(",") < 0) {
        return str; // nothing to do
    }
    StringBuilder result = new StringBuilder(str.length());
    for (String token : str.split(" ", -1)) {
        if (token.indexOf(",") > 0) {
            String[] parts = token.split(",");
            if (parts.length == 2 && parts[0].equals(parts[1])) {
                token = parts[0];
            }
        } 
        result.append(token + " ");
    }
    return result.delete(result.length() - 1, result.length()).toString();
}