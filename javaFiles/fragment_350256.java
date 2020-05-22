public static void print(String str) {
    System.out.println(str);
}

public static void print(String[] arr) {
    StringBuilder builder = new StringBuilder();
    for (int i=0; i<arr.length; i++) {
        builder.append(arr[i]);
        if (i<arr.length-1)
            builder.append(", ");
    }
    System.out.println(builder.toString());
}