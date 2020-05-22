String stringPod = String.valueOf(k);
String reverseStringPod = new StringBuilder(stringPod).reverse().toString()

if (stringPod.equals(reverseStringPod)) {
    System.out.println(k);
}