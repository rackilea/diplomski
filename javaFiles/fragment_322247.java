FileReader inputStream = null;
StringBuilder builder = new StringBuilder();

try {
    inputStream = new FileReader(args[0]);
    int c;
    char d;

    while ((c = inputStream.read()) != -1) {
        d = (char)c;
        builder.append(d);
    }
} 

finally {
    if (inputStream != null) {
        inputStream.close();
    }
}   

String myString = builder.toString();

String rows[] = myString.split("\\|NEWLINE\\|");

for (String row : rows) {
    String cols[] = row.split("\\|NEWTAB\\|");

    /* do something with cols - e.g., store */
}