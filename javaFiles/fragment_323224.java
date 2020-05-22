StringBuilder sb = new StringBuilder();
boolean skip = false;
while((String line = in.readLine()) != null) {
    if(line.equals("") {
        skip = !skip;
    }
    else if(!skip) {
        sb.append(line).append("\r\n");
    }
}
String fileContents = sb.toString();