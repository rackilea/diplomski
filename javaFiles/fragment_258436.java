public static String myJoin(int[] arr, String separator) {
    if (null == arr || 0 == arr.length) return "";

    StringBuilder sb = new StringBuilder(256);
    sb.append(arr[0]);

    //if (arr.length == 1) return sb.toString();

    for (int i = 1; i < arr.length; i++) sb.append(separator).append(arr[i]);

    return sb.toString();
}