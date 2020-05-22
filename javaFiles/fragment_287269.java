import java.util.*;

public class CWSolution {

    class FixLengthDB {
        // Index -> Letter -> All word with the Letter at Index
        HashMap<Integer, HashMap<Character, Set<String>>> indexLetterDb = new HashMap<>();

        public void storeWord(String word) {
            int l = word.length();
            for (int i = 0; i < l; i++) {
                HashMap<Character, Set<String>> letterDb = indexLetterDb.get(i);
                if (letterDb == null) {
                    letterDb = new HashMap<>();
                    indexLetterDb.put(i, letterDb);
                }

                Set<String> list = letterDb.get(word.charAt(i));
                if (list == null) {
                    list = new HashSet<>();
                    letterDb.put(word.charAt(i), list);
                }

                list.add(word);
            }
        }

        public Set<String> getList(int i, char c) {
            HashMap<Character, Set<String>> letterDb = indexLetterDb.get(i);
            if (letterDb == null) {
                return null;
            }
            return letterDb.get(c);
        }
    }

    //create the data structure that will store the dictionary
    private HashMap<Integer,FixLengthDB> db = new HashMap<>();
    private List<String> allWords;

    public CWSolution(List<String> allWords)
    {

        //construct the background structure

        this.allWords = allWords;
        //go through each word
        for(String item : allWords) {
            FixLengthDB fixLengthDB = db.get(item.length());

            if (fixLengthDB == null) {
                fixLengthDB = new FixLengthDB();
                db.put(item.length(), fixLengthDB);
            }

            fixLengthDB.storeWord(item);
        }
    }

    public List<String> solutions(String pattern, int maxRequired)
    {

        FixLengthDB fixLengthDB = db.get(pattern.length());
        if (fixLengthDB == null) {
            return new ArrayList<>();
        }

        Set<String> shortList = null;
        int shortListIndex = 0;
        int l = pattern.length();
        for (int i = 0; i < l; i++) {
            if (pattern.charAt(i) == '*') {
                continue;
            }
            Set<String> set = fixLengthDB.getList(i, pattern.charAt(i));
            if (set == null) {
                return new ArrayList<>();
            }

            if (shortList == null || shortList.size() > set.size()) {
                shortList = set;
                shortListIndex = i;
            }
        }

        if (shortList == null) {
            return allWords;
        }

        HashSet<String> result = new HashSet<>(shortList);
        for (int i = 0; i < l; i++) {
            if (i == shortListIndex || pattern.charAt(i) == '*') {
                continue;
            }
            Set<String> set = fixLengthDB.getList(i, pattern.charAt(i));
            result.retainAll(set);
        }

            // TODO truncate result list according to 'maxRequired' parameter
    return new ArrayList<>(result);
    }
}