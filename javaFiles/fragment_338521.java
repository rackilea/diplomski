public static String enrcyptText(String str, int shift){
    int count = 0;
    String[] parts = str.split("[\\W]");
    // For updating the array, better to use the classic
    // for loop instead of the enhanced for loop
    for (int i = 0; i < parts.length; ++i){ 
        shift = shift * (count + 1) + 1;
        count++;                      // Could do this before previous line and remove the + 1 in (count + 1)
        parts[i] = encryptWord(parts[i], shift); // See note below
    }
    return String.join(" ", parts);
}