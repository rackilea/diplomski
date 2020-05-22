public String getInitials() {
    String words[] = competitorName.split(" ");
    StringBuilder builder = new StringBuilder();
    for(String word : words) {
        builder.append(word.charAt(0));
    }
    return builder.toString();
}