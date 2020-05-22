public static String getNumber(String phoneNumber){

String convertedNum = "";
for (int i = 0; i < phoneNumber.length(); ++i)
    char ch = phoneNumber.charAt(i);
    ch = Character.toUpperCase(ch);

    if (ch == 'A' || ch == 'B' || ch == 'C')
        convertedNum  = convertedNum + "2"; //append to the string
    else if(ch == 'D' || ch == 'E' || ch == 'F')
        convertedNum  = convertedNum + "3";
    ...

return convertedNum; //then return it at the end
}