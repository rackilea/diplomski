class MyVer
{
    String Version;
    long Content;
    String Provide;
    Config UserConfig;
    Config Icon;
    String Source;              
}

class Config
{
    String Checksum;
    String Source;          
}

public static void main(String[] args) 
{
    String s = "Version:\"1\";Content:2013091801;Provide:\"Airtel\";UserConfig :{  Checksum = \"sha1-234448e7e573b6dedd65f50a2da72245fd3b\";  Source = \"content\\user.ini\";};Icon:{  Checksum = \"sha1-a99f835tytytyt3177674489770e613c89390a8c4\";  Source = \"content\\resept_ico.bmp\";};";                

    String startingBracePattern = Pattern.quote("{");
    String endBracePattern = Pattern.quote("}");
    s=s.replaceAll(Pattern.quote("\\"), "\\\\\\\\"); //Replacing all the single \ with double \\
    s = s.replaceAll("\\s*"+startingBracePattern +"\\s*", "\\{\""); //Replacing all the `spaces { spaces` with  `{"`  MEANS all the { to replace with {"
    s = s.replaceAll(";\\s*"+endBracePattern +"\\s*;", "\\};"); //Replacing all the `; spaces } spaces ;` with  `},"` MEANS all the ;}; to replace with };

    s = "{\"" + s.substring(0, s.length() - 1) +"}";    //Removing last ; and appending {" and }        
    s = s.replaceAll("\\s*:", "\":");                   // Replacing all the `space with :` with `":`       
    s = s.replaceAll("\\s*;\\s*", ",\"");               //Replacing all the `spaces ; spaces` with `,"`
    s = s.replaceAll("\\s*=\\s*", "\":");               //Replacing all the `spaces = spaces` with  `":`

    Gson gson = new Gson();
    MyVer newObj = gson.fromJson(s, MyVer.class);
}