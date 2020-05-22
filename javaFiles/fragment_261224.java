// capture all the words first into an array
// the array below is for test purposes
String[] words = {"1", "2", "3", "5", "1", "1", "3", "4", "1", "5", "7", "0"};

Arrays.sort(words);  // sort the array - this is vital or the rest wont work
String last = words[0];
int count = 0;
for (String word : words) {
    if (word.equals(last)) {
        count++;
    } else {
        System.out.println(last + "=>" + count);

        count = 1;
        last = word;
    }
}
System.out.println(last + "=>" + count);