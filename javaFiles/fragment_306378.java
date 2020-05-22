if (text.charAt(i) == ' ') {
    continue;
} else if (text.substring(i, i + 5).equalsIgnoreCase("00001")){
    builder.append( "a" );   
}
...