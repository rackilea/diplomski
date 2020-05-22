StringBuilder builder = new StringBuilder();
private String arabicDigits="";

public String arabicNumners(String englishNumber) {

String str=englishNumber;
char[] arabicChars = {'\u0660','\u0661','\u0662','\u0663','\u0664','\u0665','\u0666','\u0667','\u0668','\u0669'};

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



   return builder.toString();



}