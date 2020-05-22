try (BufferedReader br = Files.newBufferedReader(Paths.get(filepath))) {
    for (String strLine; (strLine = br.readLine()) != null; ) {
        Pattern p = Pattern.compile("Stream:.*? \"(.*?)\"");
        for (Matcher m = p.matcher(strLine); m.find(); ) {
            String streamInp = m.group(1);
            System.out.println(streamInp);
        }
    }
}