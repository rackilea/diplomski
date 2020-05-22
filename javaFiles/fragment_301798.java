char[] arabicChars = {'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};
StringBuilder builder = new StringBuilder();
for(int i =0;i<str.length();i++)
{
    if(Character.isDigit(str.charAt(i)))
    {
        builder.append(arabicChars[(int)(str.charAt(i))-48]);
    }
    else
    {
        builder.append(str.charAt(i));
    }
}
System.out.println("Number in English : "+str);
System.out.println("Number In Arabic : "+builder.toString() );