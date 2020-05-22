String input = "These are appleapple and guavaguava";
String[] words = input.split(" ");

for (String w : words) {
    int half = w.length() / 2;
    String firstHalf = w.substring(0, half);  // split in half
    String secondHalf = w.substring(half);
    if (firstHalf.equals(secondHalf)) {  // if equal halves then only print one
        System.out.print(firstHalf + " ");
    } else {
        System.out.print(w + " ");
    }
}