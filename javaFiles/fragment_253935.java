String text = searchMP3Results.getText();
StringBuilder output = new StringBuilder();
for ( String s : text.split("\n") ) {
    if ( java.util.regex.Pattern.matches("^([a-zA-Z]:)?(\\\\[\\s\\.a-zA-Z0-9_-]+)+\\\\?$", s) ) {
        output.append(s).append("\n");
    }
}