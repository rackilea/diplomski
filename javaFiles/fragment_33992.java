import java.util.*;
import java.util.regex.*;  
import java.net.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        String jsCode    ="<script>function getcookie(Name){\n" +
                    "  var search=Name+\"=\";\n" +
                    "  if(document.cookie.length>0){\n" +
                    "    offset=document.cookie.indexOf(search)\n" +
                    "    if(offset!=-1){\n" +
                    "      offset+=search.length\n" +
                    "      end=document.cookie.indexOf(\";\",offset)\n" +
                    "      if(end==-1){end=document.cookie.length}\n" +
                    "      return unescape(document.cookie.substring(offset, en))\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n" +
                    "   var player = new Playerjs({\n" +
                    "  \"id\":\"player\",\n" +
                    "  \"poster\":\"https://media.example.com/img/2147414277.jpg\",\n" +
                    "  \"file\":\"[SD (480p)]https://example.com/2147414277.mp4?md5=OFvyZ55egHb4A5hUZJvSEQ&time=1580513886 or https://example1.com/2147414277.mp4?md5=OFvyZ55egHb4A5hUZJvSEQ&time=1580513886&ip=176.9.117.35,[HD (720р)]https://example2.com/720/2147414277.mp4?md5=GXD4cKVnM5RVY363Uxn9ww&time=1580513886 or https://exampl3.com/720/2147414277.mp4?md5=GXD4cKVnM5RVY363Uxn9ww&time=1580513886&ip=190.9.117.35\",\n" +
                    "  \"default_quality\":\"SD (480p)\"\n" +
                    "  });\n" +
                    "  function PlayerjsEvents(event,id,data){\n" +
                    "   if(event==\"start\"){\n" +
                    "      var xhttp = new XMLHttpRequest();\n" +
                    "  xhttp.open(\"GET\", \"stat.php?id=2147414277\", true);\n" +
                    "  xhttp.send();\n" +
                    "   }\n" +
                    "   if(event==\"end\"){\n" +
                    "   \n" +
                    "   }\n" +
                    "   }</script>";




        List<String> urls = new ArrayList<String>();
       String myUrlPattern = "((https?|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern p = Pattern.compile(myUrlPattern);
        Matcher m = p.matcher(jsCode);
        while (m.find()) {
            urls.add(m.group());
        }
        for(String s: urls)
         System.out.println(s);

     }
}