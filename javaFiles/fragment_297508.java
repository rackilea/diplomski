String time = "PT14H01M00S";
String substring = time .substring(2);
substring = substring.replace("H", ":");
substring = substring.replace("M", ":");
substring = substring.replace("S", "");

System.out.println(substring);