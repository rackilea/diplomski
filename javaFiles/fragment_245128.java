String[] text = editText.getText().toString().split(" ");
List<String> wordList = new ArrayList<String>(Arrays.asList(text)); 

List<String> groups = new ArrayList<String>();
getGroups(3, wordList);

public static void getGroups(int n, List<String> wordList) {

    String temp = "";

    if (wordList.size() <= n) {
        for (String s : wordList)
            temp = temp + s + " ";
        groups.add(temp.trim());
        return;
    }

    for (int i = 0; i < n; i++)
        temp = temp + wordList.get(i) + " ";

    groups.add(temp);
    wordList.remove(0);
    getGroups(n, wordList);
}