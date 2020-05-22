// Delete all file lines where the NAME column equals 
// the name 'brandon' or 'Brandon' or 'BRANDON'.

boolean ignoreLetterCase = true;  // ignore Letter Case by default  
int deleteIfInColumn = 3;
String nameToDelete = "Brandon"; 
String criteria = ignoreLetterCase ? nameToDelete .toLowerCase() : nameToDelete;

while ((line = r1.readLine()) != null) {
    String procString = ignoreLetterCase ? line.toLowerCase : line;
    String[] columnData = procString.split(",");
    if (columnData[deleteIfInColumn].equals(criteria)) {
        continue;  // Skip to next file line
    }
    w1.write(line);
    w1.newLine();
}