String input = "0nd0-cathay bank (federal saving)";
// case-sensitive Pattern:
//                              | group 1: first letter
//                              |      | group 2: any other character if applicable
//                              |      |    | word boundary
Pattern p = Pattern.compile("([a-z])(.*?)\\b");
// Pattern for all capital letters 
// Pattern p = Pattern.compile("([A-Z])(.*?)\\b");
// initializing StringBuffer for appending
StringBuffer sb = new StringBuffer();
Matcher m = p.matcher(input);
// iterating over matches
while (m.find()) {
   // appending replacement:
   //                      | 1st letter capitalized
   //                      |                        | concatenated with...
   //                      |                        |     | any other character
   //                      |                        |     | within word boundaries
   m.appendReplacement(sb, m.group(1).toUpperCase().concat(m.group(2)));
   // Replacement for all capital letters
   // m.appendReplacement(sb, m.group(1).concat(m.group(2).toLowerCase()));
}
// appending tail if any
m.appendTail(sb);
System.out.println(sb.toString());