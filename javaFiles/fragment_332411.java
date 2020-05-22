public static<T> String toStringArrayNonNulls (T[] data) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    int n = data.length;
    int i = 0;
    for(; i < n; i++) {
        if(data[i] != null) {
            sb.append(data[i].toString());
            break;
        }
    }
    for(; i < n; i++) {
        if(data[i] != null) {
            sb.append(",");
            sb.append(data[i].toString());
        }
    }
    sb.append("]");
    return sb.toString();
}