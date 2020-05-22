String[] arr = new String[]{"i", "am", "super", "HERO"};

StringJoiner sj = new StringJoiner(" ");
// Capitalize first word
sj.add(Character.toUpperCase(arr[0].charAt(0)) + arr[0].substring(1));
// Add the remaining words
for (int i = 1; i < arr.length; i++) {
    sj.add(arr[i]);
}
String result = sj.toString() + ".";

System.out.println(result);