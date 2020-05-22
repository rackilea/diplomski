import java.io.IOException;

/*
::   Punctuation             Hexadecimal equivalent
::   ----------------------------------------------
::   Space ( )               %20
::   Comma (,)               %2C
::   Question mark (?)       %3F
::   Period (.)              %2E
::   Exclamation point (!)   %21
::   Colon (:)               %3A
::   Semicolon (;)           %3B
::   Line feed               %0A --> New line   %0D%0A
::   Line break (ENTER key)  %0D --> New line   %0D%0A
*/

public class Main {
    static String test = "hi";
    private static String attachment;
    private static String to;
    private static String cc;
    private static String subject;
    private static String body;
    public static void main (String[] args){

        attachment  = "F:\\pietquest.png";
        to          = "test@test.de";
        cc          = "a.b@c.de";
        subject     = "TestSubject 123";
        body        = "Hi, what\'s going on%0D%0Anew line";

        body     = replace(body);
        subject  = replace(subject);

        String[] value = WindowsRegistry.readRegistry("HKEY_LOCAL_MACHINE\\SOFTWARE\\Clients\\Mail", "");

        if (value[10].contains("Thunderbird")){
            System.out.println("Thunderbird");
            String[] pfad = WindowsRegistry.readRegistry("HKEY_LOCAL_MACHINE\\SOFTWARE\\Clients\\Mail\\Mozilla Thunderbird\\shell\\open\\command", "");
            String Pfad = pfad[10] + " " + pfad[11];
            String argument = Pfad + " /compose \"to=" + to + ",cc=" + cc + ",subject=" + subject + ",body=" + body + ",attachment=" + attachment + "\"";
//          System.out.println(argument);
            try {
                Runtime.getRuntime().exec(argument);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (value[10].contains("Outlook")){
            System.out.println("Outlook");
            String[] pfad = WindowsRegistry.readRegistry(
                    "HKEY_LOCAL_MACHINE\\SOFTWARE\\Clients\\Mail\\Microsoft Outlook\\shell\\open\\command", "");
            String Pfad = pfad[10];
            String argument = Pfad + " /a " + attachment + " /m \"" + to 
                    + "&cc=" + cc + "&subject=" + subject + "&body=" + body + "\"";
//          System.out.println(argument);
            try {
                Runtime.getRuntime().exec(argument);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static String replace(String toReplace){
        toReplace = toReplace.replace(" ", "%20");
        toReplace = toReplace.replace(",", "%2C");
        toReplace = toReplace.replace("?", "%3F");
        toReplace = toReplace.replace(".", "%2E");
        toReplace = toReplace.replace("!", "%21");
        toReplace = toReplace.replace(":", "%3A");
        toReplace = toReplace.replace(";", "%3B");
        return toReplace;
    }
}