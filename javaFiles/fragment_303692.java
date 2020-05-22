String str = "airport";
    String originalStr = str; //creat a backup of str because you change it in your code
    Character[] chars = str.toCharArray();


    Arrays.sort(chars, new Comparator<Character>() {
        public int compare(Character c1, Character c2) {
            int cmp = Character.compare(
                    Character.toLowerCase(c1.charValue()),
                    Character.toLowerCase(c2.charValue()));
            if (cmp != 0) {
                return cmp;
            }
            return Character.compare(c1.charValue(), c2.charValue());
        }
    });

    str = String.valueOf(chars);
    System.out.println(str);


    //Iterate over the sorted String and replace the charakters in the original String with their indices in the sorted String
    for(int i = 0; i<str.length(); i++) {
        originalStr = originalStr.replaceFirst(String.valueOf(str.charAt(i)), String.valueOf(i+1));
    }
    System.out.println(originalStr);