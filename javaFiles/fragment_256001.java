String original = "1212";
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('1', "22");
        map.put('2', "1");
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<original.length();i++) {
            char ch = original.charAt(i);
            if (map.containsKey(ch)) {
                sb.append(map.get(ch));
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb);