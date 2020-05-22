import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static List<String> groups = new ArrayList<String>();
    public static String text = "the alarm clock in the table is noisy";

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>(Arrays.asList(text.split(" ")));
        getGroups(3, wordList);

        System.out.println(groups);
    }

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

        groups.add(temp.trim());
        wordList.remove(0);
        getGroups(n, wordList);
    }
}