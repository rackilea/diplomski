BufferedReader br = new BufferedReader(
        new InputStreamReader(fstream));
String strLine;
boolean registered = false;
while ((strLine = br.readLine()) != null) {
    if (strLine.startsWith(un)) {
        registered = true;
        break;
    }
}
if(registered) {
    //blah
} else {
    //blah
}