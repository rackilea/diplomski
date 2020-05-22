public String recursive(int n, StringBuilder sb) {
    String retStr = "s";
    if (n==0) {
        return retStr;
    }
    else {
        return sb.append(retStr).append(recursive(n-1, sb)).toString();
    }
}