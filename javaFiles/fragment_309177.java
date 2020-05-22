public static void main(String[] args) {
    String parentStr = "This is a parent string", childStr = "iSStr";
    //Turn both to lowcase.
    parentStr.toLowerCase(); childStr.toLowerCase();
    Integer childStrIndex = 0;
    //Run over the parent string and if you found a match then keep comparing with the next
    //character in the child string.
    for (int index = 0 ; index < parentStr.length(); index++) {
        Character currChar = parentStr.charAt(index);
        if (childStr.length() <= childStrIndex)
            break;
        if (currChar.equals(childStr.charAt(childStrIndex)))
            childStrIndex++;
    }
    // If at the end you are in the last character of the child string, then is true.
    if (childStrIndex >= childStr.length())
        System.out.print(true);
    else
        System.out.print(false);
}