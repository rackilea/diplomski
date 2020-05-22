// Read the file using whitespace as a delimiter (default)
// so that the input will be split into words
Scanner file = new Scanner(new File("crime_and_punishment.txt"));

Set<String> crime = new HashSet<>();
// For each word in the input
while (file.hasNext()) {
    // Convert the word to lower case, trim it and insert into the set
    // In this step, you will probably want to remove punctuation marks
    crime.add(file.next().trim().toLowerCase());
}

System.out.println("Enter a word to search for: ");
Scanner input = new Scanner(System.in);
// Also convert the input to lowercase
String search = input.next().toLowerCase();

// Check if the set contains the search string
if (crime.contains(search)) {
    System.out.println("Yes");
} else {
    System.out.println("No");
}