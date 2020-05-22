import java.util.regex.*;
Pattern p1 = Pattern.compile("X-MOON-EXPIRED', \"([^\"]*)\"");
Pattern p2 = Pattern.compile("X-MOON-TOKEN', \"([^\"]*)\"");
String html = "<script type=\"text/javascript\"> $(function() {   $.ajaxSetup({     beforeSend: function(xhr) {       xhr.setRequestHeader('X-MOON-EXPIRED', \"1445350653\");       xhr.setRequestHeader('X-MOON-TOKEN', \"10dafe974cc156d2d3b7fd9bb1e4e3ed\");     }   }); }); </script>";
Matcher m1 = p1.matcher(html);
Matcher m2 = p2.matcher(html);
if (!m1.find() || !m2.find()) {
    throw new Exception("Didn't match");
}
System.out.println(String.format("X-MOON-EXPIRED=%s, X-MOON-TOKEN=%s", m1.group(1), m2.group(1)));