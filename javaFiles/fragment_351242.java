public static void main(final String[] args) throws Exception {
    BufferedReader fileReader = new BufferedReader(new FileReader("emoticon.txt"));
    String line = "";
    while ((line = fileReader.readLine()) != null) {
        line = line.replaceAll("Â", "");
        line = line.replace("" + ((char) 160), " ");
            System.out.println("line: " + line);
        String[] icons = line.split("\\s+");
        for (String icon : icons) {
            System.out.println(icon);
        }
        System.out.println("=======================");
    }
}