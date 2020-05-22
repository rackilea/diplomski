List<String> strDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday", "Sunday" );

     String weekday = scanText.nextLine();

     int day = 0;
     if(strDays.contains(weekday)) {

         day = strDays.indexOf(weekday) + 1;
     } else {
         System.out.print("Error! Invalid day: ");
         weekday = scanText.nextLine();
     }