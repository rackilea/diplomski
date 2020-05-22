String input = "....";
List<String> searchStrings = Arrays.asList("oh oh!", "really");

int count = 0;
for (String searchString : searchStrings) {
    int indexOf = input.indexOf(searchString);
    while (indexOf > -1) {
        count++;
        indexOf = input.indexOf(searchString, indexOf+1);
    }
}