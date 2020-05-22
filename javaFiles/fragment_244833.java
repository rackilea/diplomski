String toBeSanitized = "(*this*)* text is ^0nly for t3st!ng!";
    String sanitizedStr = "";
    int length = toBeSanitized.length();
    for (int i=0;i < toBeSanitized.length(); i++){
        if ((toBeSanitized.charAt(i) >= 'a' && toBeSanitized.charAt(i) <= 'z') ||
        (toBeSanitized.charAt(i) >= 'A' && toBeSanitized.charAt(i) <= 'Z') ||
        (toBeSanitized.charAt(i) >= '0' && toBeSanitized.charAt(i) <= '9') || 
        toBeSanitized.charAt(i) == ' ') // optional
        {
            sanitizedStr += toBeSanitized.charAt(i);
        }
    }

    System.out.println(sanitizedStr);