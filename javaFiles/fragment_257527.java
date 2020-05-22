String template = "abcd";
StringBuilder populatedTemplate = new StringBuilder();
HashMap<Character, Character> map = new HashMap<>();
map.put('a', 'b');
map.put('b', 'c');
for (int i = 0; i < template.length(); i++) {
    populatedTemplate.append(
            map.getOrDefault(template.charAt(i), template.charAt(i)));
}
System.out.println(populatedTemplate);