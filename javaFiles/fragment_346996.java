// This builds each row
for (int row = maxFrequency; row > 0; row--) {
    // This is used instead of String concatenation (String + String)
    // This is the preferred mechanism for doing String concatenation
    // in loops as it uses less memory and will generally be faster...
    StringBuilder sb = new StringBuilder(30);

    // We need to inspect each value in the array to determine
    // if we need to display something...
    // The basic idea is, we will only start displaying "x"
    // when the value in the array >= the row number...
    for (int value : a) {
        // This just appends each column value as
        // required, prefixing and suffixing it with spaces
        sb.append(" ");
        if (value >= row) {
            sb.append("x");
        } else {
            sb.append(" ");
        }
        sb.append(" ");
    }
    // Print the row...
    System.out.println(sb.toString());
}