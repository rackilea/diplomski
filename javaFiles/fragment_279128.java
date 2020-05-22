Pattern p = Pattern.compile("(.*?)(_copy(\\d+))?(\\..*)?");

while(new File(fileName).exists())
{
    Matcher m = p.matcher(fileName);
    if (m.matches()) {
        String prefix = m.group(1);
        String numberMatch = m.group(3);
        String suffix = m.group(4);
        int copyNumber = numberMatch == null ? 1 : Integer.parseInt(numberMatch) + 1;

        fileName = prefix;
        fileName += "_copy" + copyNumber;
        fileName += (suffix == null ? "" : suffix);
    }
}