public static void eliminateCommon(String file1, String file2) throws IOException
{
    List<String> lines1 = readLines(file1);
    List<String> lines2 = readLines(file2);

    Iterator<String> linesItr = lines1.iterator();
    while (linesItr.hasNext()) {
        String checkLine = linesItr.next();
        if (lines2.contains(checkLine)) {
            linesItr.remove();
            lines2.remove(checkLine);
        }
    }

    //now lines1 will contain string that are not present in lines2
    //now lines2 will contain string that are not present in lines1
    System.out.println(lines1);
    System.out.println(lines2);

}

public static List<String> readLines(String fileName) throws IOException
{
    List<String> lines = new ArrayList<String>();
    FileInputStream fs = new FileInputStream(fileName);
    BufferedReader br = new BufferedReader(new InputStreamReader(fs));
    String line = null;
    while ((line = br.readLine()) != null) {
        String account = line.substring(0, 10);
        lines.add(account);
    }
    return lines;
}