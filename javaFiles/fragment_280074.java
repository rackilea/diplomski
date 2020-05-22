String[] allowedChar = {"Å", "μ", "]"};
String allowedChars = "";
for (String ch : allowedChar)
    if (ch.matches("^[^\\x00-\\x7F]$"))
        allowedChars += ch;
String Modified_remark = final_remark.replaceAll("[^\\x00-\\x7F" + allowedChars + "]", "");