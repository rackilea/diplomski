public static void main(String[] args) throws Exception {
    Map<Character, Integer> characterCounter = new HashMap<Character, Integer>();
    File file = new File("/Users/Downloads/text.txt`enter code here`");
    int totalCount = 0;
    try(Scanner s = new Scanner(file, "utf-8")){
        while (s.hasNext()) {
            char[] chars = s.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                totalCount = totalCount + 1;
                if(!Character.isLetter(c)){
                    continue;
                }
                else if (characterCounter.containsKey(c)) {
                    characterCounter.put(c, characterCounter.get(c) + 1);
                } else {
                    characterCounter.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> countedArray : characterCounter.entrySet()) {
            System.out.println(countedArray.getKey() + ": " + countedArray.getValue() + " - " + ((double) countedArray.getValue()/ (double) totalCount));        }
    }
}