String input = "Input text, with words, punctuation, etc. Well, it's rather short.";
Pattern p = Pattern.compile("[\\w']+");
Matcher m = p.matcher(input);

while ( m.find() ) {
    System.out.println(input.substring(m.start(), m.end()));
}