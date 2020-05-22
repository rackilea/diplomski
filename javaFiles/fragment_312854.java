ArrayList<String> bla = new ArrayList<String>();
for(int i = 0; i < input.length(); i++) {
    StringBuilder s = new StringBuilder();

    if(input.charAt(i) != ' ')
        s.append(input.charAt(i));

    if(input.charAt(i) == ' ' || i+1 == input.length())
        bla.add(s.toString());
}