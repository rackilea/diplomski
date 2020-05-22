String input = "2345678";

StringBuilder sb = new StringBuilder();
for(char c : input.toCharArray()) {
    if(Character.getNumericValue(c) % 2 == 0) {
        sb.append(c);
    }
}
String output = sb.toString();

System.out.println(output);