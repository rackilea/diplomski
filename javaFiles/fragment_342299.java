String jsonString = "[ \n" + "{ \n" + "   LastName=abc,  \n" + "   FirstName=xyz,  \n"
            + "   EmailAddress=s@s.com,  \n" + "   IncludeInEmails=false \n" + "}, \n" + "{  \n"
            + "  LastName=mno,  \n" + "  FirstName=pqr,  \n" + "  EmailAddress=m@m.com,  \n" + "  Number=123,  \n"
            + "  IncludeInEmails=true \n" + "} \n" + "] \n";

    System.out.println("Before:\n" + jsonString);
    jsonString = jsonString.replaceAll("([\\w]+)[ ]*=", "\"$1\" ="); // to quote before = value
    jsonString = jsonString.replaceAll("=[ ]*([\\w@\\.]+)", "= \"$1\""); // to quote after = value, add special character as needed to the exclusion list in regex
    jsonString = jsonString.replaceAll("=[ ]*\"([\\d]+)\"", "= $1"); // to un-quote decimal value
    jsonString = jsonString.replaceAll("\"true\"", "true"); // to un-quote boolean
    jsonString = jsonString.replaceAll("\"false\"", "false"); // to un-quote boolean

    System.out.println("===============================");
    System.out.println("After:\n" + jsonString);