Map<Character, List<String>> map = new HashMap<Character, List<String>>();

// creating list for each char
for(int i=0;i<26;i++){
    char ch = (char) ('a' + i);
    map.put(ch,new ArrayList<String>());
}

// storing some sample dictionary data or make a function for it
map.get("abcd".charAt(0)).add("abcd");
map.get("bcde".charAt(0)).add("bcde");
map.get("cdef".charAt(0)).add("cdef");
map.get("fghi".charAt(0)).add("fghi");
map.get("ijkl".charAt(0)).add("ijkl");

String searchWord = "cd";

// searh the given String
List<String> wordList =map.get(searchWord.charAt(0));
int idx =0;

for (String st : wordList) {
    if (st.startsWith(searchWord)) {
        idx = wordList.indexOf(st);
        System.out.println("position="+idx);   //display index in log

       break;
      }
  }

  // if require, In idx variable : add the size() of all list 
      // which come before the give searh char
  // ListView.setSelection(idx); //set listView scroll