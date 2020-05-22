public static String twoDArrToString(Object[][] arr) {
    System.out.println(arr.length);
    StringBuilder sb = null;
    if (arr.length > 0) {
        sb = new StringBuilder(arr.length * arr[0].length);//Making it a tiny bit more efficient
    } else {
        return "";//Doesn't make sense to have a zero length array
    }

    for (Object[] objArr : arr) {
        sb.append("[");
        for (Object obj : objArr) {
            sb.append(obj).append(", ");
        }
        sb.append("]\n");
    }
    return sb.toString();
}