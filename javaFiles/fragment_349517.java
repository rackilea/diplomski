String[] words = new String[]{"pig", "dog", "cat", "fish", "bird"};
char[][] charWords = new char[words.length][];

for (int j = 0; j < words.length; j++) {
    String str = words[j];
    char[] chars = new char[str.length()];

    for (int i = 0; i < str.length(); i++) {
        char cha = str.charAt(i);
        cha = Character.toUpperCase(cha);
        cha += 65248;
        chars[i] = cha;
    }

    charWords[j] = chars;
}

System.out.println(Arrays.stream(charWords).map(String::new).collect(Collectors.toList()));