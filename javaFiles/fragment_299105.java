String s1 = "vera", s2 = "ronaldo";
StringBuilder sb = new StringBuilder();

int minLength = Math.min(s1.length(), s2.length());
for (int i = 0; i < minLength; i++){
    sb.append(s1.charAt(i));
    sb.append(s2.charAt(i));
}

for (int i = minLength; i < s1.length(); i++){
    sb.append(s1.charAt(i));
}

for (int i = minLength; i < s2.length(); i++){
    sb.append(s2.charAt(i));
}

System.out.println(sb.toString());