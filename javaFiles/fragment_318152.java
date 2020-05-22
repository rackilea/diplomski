String[] split = search.split(" ");
for (String s : split) {
if (hset.contains(s.toLowerCase()) {
    System.out.println("Yes");
    break; //no need to continue if a stop word is found
} else {
    System.out.println("No");
}