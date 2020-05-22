Pattern pattern =  Pattern.compile("\\s\\d\\d\\s");
int lineNum = 0;

Scanner scannerLines = new Scanner(System.in);
while (scannerLines.hasNextLine()) {
    lineNum++;
    while (scannerLines.hasNextLine()) {
        String line = scannerLines.nextLine();
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            int value = Integer.parseInt(matcher.group().trim());
            System.out.println("Found " + value + " at line " + lineNum);
        }
    }
}