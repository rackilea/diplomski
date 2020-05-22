String input = "These are appleapple and guavaguava"; 
String words [] = input.split(" ");

for (String w : words) {

    if (w.length() % 2 == 0) {
        String firstHalf = w.substring(0, w.length() / 2 );
        String secondHalf = w.substring(w.length() / 2);
        if (firstHalf.equals(secondHalf)) {
            System.out.println(firstHalf);
        }
        else {
            System.out.println(w);
        }
    }
    else {
        System.out.println(w);
    }
}