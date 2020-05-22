StringBuilder concatenated = new StringBuilder(firstString.length()+secondString.length());
for (int i = 0; i < firstString.length(); i++){
    concatenated.append(firstString.charAt(i));
}
for (int i = 0; i < secondString.length(); i++){
    concatenated.append(secondString.charAt(i));
}
System.out.println(concatenated.toString());