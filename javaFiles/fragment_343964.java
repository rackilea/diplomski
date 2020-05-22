final Pattern p = Pattern.compile("^[0-9]{8}[#](FRI|SAT|SUN)$", Pattern.MULTILINE);
//                                                              ^^^^^^^^^^^^^^^^^
final Matcher m = p.matcher(
          "09042012#SUN\r" 
        + "09022012#FRI\r" 
        + "09032012#SAT\r");
while (m.find())
{
    final String result = m.group();
    System.out.println(result);
}