String standardTime = br.readLine();//user inputs time in standard form

do {
    // check
} while ((standardTime.length()) != 8 || (min1 >= 6));

System.out.println();
String minute1 = standardTime.substring(3);
min1 = Integer.parseInt(minute1);
String minute2 = standardTime.substring(5);
min2 = Integer.parseInt(minute2);