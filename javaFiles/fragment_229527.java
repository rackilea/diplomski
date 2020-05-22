Scanner scanner = new Scanner(new File(fileName));
List<String> procList = null;
String line = null;
String previousAlpha = null;
while (scanner.hasNextLine()){
    line = scanner.nextLine();

    if (previousAlpha == null) {
        // very first line in the file
        procList = new ArrayList<String>();
        procList.add(line);
        System.out.println(line);
        previousAlpha = line.split(",")[0];
    }
    else if (line.contains(previousAlpha)) {
        // same letter as before
        procList.add(line);
    }
    else {
        // new letter, but not the very first
        // line
        System.out.println(procList);

        procList = new ArrayList<String>();
        procList.add(line);
        System.out.println(line);
        previousAlpha = line.split(",")[0];

    }
}