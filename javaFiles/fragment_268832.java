// ....
{

    user_text = cleanString;
    String[] words = user_text.split(" ");
    Set<String> wordSet = new HashSet<>();

    int error = 0;

    for (String word : words) {
        // wordSet is another data-structure. Its only for duplicates checking, don't mix it with dictionary
        if(!wordSet.contains(word)) {

            // put all your logic here

            wordSet.add(word);
        }
    }

    if (error == 0) {
        System.out.println("No mistakes found");
    }
}
// ....