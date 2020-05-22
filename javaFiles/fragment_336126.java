String Inputstr = "SOME <Module Name> Module";                  
Pattern ptrn = Pattern.compile("<.*>", Pattern.DOTALL);
Matcher mtch = ptrn.matcher(Inputstr);
if (mtch.find()) {
    System.out.println("The <...> part: " + mtch.group());  // <Module Name>
}