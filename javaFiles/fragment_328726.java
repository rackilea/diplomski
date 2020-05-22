StringBuilder u = new StringBuilder(); // notice the change to StringBuilder here
StringBuilder l = new StringBuilder();
String s = inp2.nextLine();

for (int j = 0 ; j < s.length() ; j ++) {
    char ch = s.charAt(j);
    if (Character.isLowerCase(ch))
        l.append(ch);
    else u.append(ch);
}