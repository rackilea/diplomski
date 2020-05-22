//String that needs to be searched
    String s= "ccoptarra";

    //Words that need to be found
    String[] words = {"car","pot","bag"};

    List<Integer> count = new ArrayList<Integer>();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i=0; i<s.length();i++) {
        char c = s.charAt(i);
        if (map.get(c) != null) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    for (int i=0; i<words.length; i++) {
        int min = Integer.MAX_VALUE;
        for (int j=0; j<words[i].length(); j++) {
            Integer value = map.get(words[i].charAt(j));
            if (value == null) {
                min = 0;
            } else if (value < min) {
                min = value;
            }
        }
        count.add(min == Integer.MAX_VALUE ? 0 : min);
    }

    for(int i=0; i<count.size(); i++)
        System.out.println("Word: "+words[i]+", count = "+count.get(i));