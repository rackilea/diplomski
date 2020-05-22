Pattern p = Pattern.compile("[/\\\\]([a-zA-Z0-9_]+\\.ncx)$");
Matcher m = p.matcher("\\sample.ncx");
if (m.find())
{
  System.out.printf("The filename is '%s'%n", m.group(1));
}