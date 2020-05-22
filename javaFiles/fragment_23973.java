String searchTerm = ...;
searchTerm = searchTerm.toLowerCase();
for (String s : Criminals) { // loop
    if (s.toLowerCase().contains(searchTerm)) { // find
        System.out.println(s); // display
    }
}