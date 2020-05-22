Pattern pattern = Pattern.compile("^.+ (\\d+)$");

while (fileScan.hasNext()) {
    line = fileScan.nextLine();
    Matcher m = pattern.matcher(line);
    if (m.find()) {
        array[Integer.parseInt(m.group(1))-1]++;
    }
}