public static StringBuilder singleOccurence(String s)
{
    StringBuilder sb = new StringBuilder();
    if (s.length() > 0) {
        char prev = s.charAt(0);
        sb.append(prev);
        for (int i = 1; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur != prev) {
                sb.append(cur);
                prev = cur;
            }
        }
    }
    return sb;
}