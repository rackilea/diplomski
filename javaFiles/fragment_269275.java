import java.util.regex.*;

String line     = "I have your PaTTerN right here";
String pattern  = "pattern";      
Pattern regcomp = Pattern.compile(pattern, CASE_INSENSITIVE
                                        | UNICODE_CASE
                // comment next line out for legacy Java \b\w\s breakage 
                                        | UNICODE_CHARACTER_CLASSES  
                                );    
Matcher regexec = regcomp.matcher(line);    
if (regexec.find()) {
    System.out.println("matched");
} 