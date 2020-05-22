String[] arr = new String[]{"i", "am", "super", "HERO"};

StringJoiner sj = new StringJoiner(" ");
// Capitalize first word
sj.add(capitalize(arr[0]));
// Add the remaining words
for (int i = 1; i < arr.length; i++) {
    sj.add(arr[i]);
}
String result = sj.toString() + ".";

System.out.println(result);