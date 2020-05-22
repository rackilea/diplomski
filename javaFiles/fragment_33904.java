StringBuilder str = new StringBuilder();
BufferedReader reader = null;
    try {
    str.append("[\n");

    for( String line = reader.readLine(); line != null; line = reader.readLine() ){
        str.append(line).append(",\n");
    }

    str.setLength(str.length()-2);
    str.append(']');

} catch( Exception ex ){
    if(reader != null){ reader.close(); }
}