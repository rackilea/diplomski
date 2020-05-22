StringBuilder sb = new StringBuilder("[").append(tokens.get(0));
for (int i = 1; i < tokens.size(); i++){
    sb.append('|').append(tokens.get(i));
}
sb.append(']');
return sb.toString();