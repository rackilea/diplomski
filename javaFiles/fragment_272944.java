boolean foundString = false;
int count = 0, lineNum = 1;
while(scanner.hasNextLine()){
    String line = scanner.nextLine();
    if(line.equals("STRINGTOFIND")){
        foundString = true;
        break; // Break out of the loop
    }
    else if(line.equals("STRINGTOCOUNT")) count++;
    lineNum++;
}
// Code that uses "foundString" and/or "lineNum"