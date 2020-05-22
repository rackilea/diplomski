String input_str = "http://www.some.site.com?and=value&s=more\nhttp://10.23.46.134\nemail@me.at.site.com";
String regex = "(([A-Za-z]{3,9}:(?://)?)(?:[-;:&=+$,\\w]+@)?[A-Za-z0-9.-]+|(?:www\\.|[-;:&=+$,\\w]+@)[A-Za-z0-9.-]+)((?:/[+~%/.\\w-]*)?\\??(?:[-+=&;%@.\\w]*)#?(?:[.!/\\\\\\w]*))?";
String res = input_str.replaceAll(regex, "<a href='$0'>$0</a>");
System.out.println(res);
// => 
//  <a href='http://www.some.site.com?and=value&s=more'>http://www.some.site.com?and=value&s=more</a>
//  <a href='http://10.23.46.134'>http://10.23.46.134</a>
//  <a href='email@me.at.site.com'>email@me.at.site.com</a>