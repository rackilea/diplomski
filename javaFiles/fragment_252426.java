public class fancyClock {
public static void main(String[] args) {
int counter = 1;
int year = 1969;
boolean isLeapYear = false;
int yearsUntilLeapYear = 2;
int days = 1;
int daysTemp = 0;
int months = 1;
String month = "";
int hours = 24;
int minutes = 00;
int day = 0;

long millis = System.currentTimeMillis();
System.out.println(millis);


while (counter == 1) {
  if (millis - 86400000 > 0) {
     days++;
     millis = millis - 86400000;
  } else {
     counter--;
  }
}
counter++;
daysTemp = days;
while (counter == 1) {
if (yearsUntilLeapYear == 0) {
   isLeapYear = true;
}
  // ESSENTIAL!!! IF COND MUST BE MOD, NOT MINUS!!!
  if (daysTemp % 365 > 0 && isLeapYear == false) {
     daysTemp = daysTemp - 365;
     year++;
     yearsUntilLeapYear--;
  } else if (daysTemp % 366 > 0 && isLeapYear == true) {
     isLeapYear = false;
     yearsUntilLeapYear = 4;
     daysTemp = daysTemp - 366;
     year++;
     yearsUntilLeapYear--;
  } else {
     counter--;
  }
}
counter++;
if (isLeapYear == true) {
   daysTemp = daysTemp + 366;
} else if (isLeapYear == false) {
   daysTemp = daysTemp + 365;
}
System.out.println("Days after flip: " + daysTemp);

while (counter == 1) {
   if ((months == 1 && (daysTemp - 31 > 0)) || (months == 3 && (daysTemp - 31 > 0)) || (months == 5 && (daysTemp - 31 > 0)) || (months == 7 && (daysTemp - 31 > 0)) || (months == 8 && (daysTemp - 31 > 0)) || (months == 10 && (daysTemp - 31 > 0)) || (months == 12 && (daysTemp - 31 > 0))) {
     daysTemp = daysTemp - 31;
     months++;
  } else if (months == 2 && isLeapYear == true && (daysTemp - 29 > 0)) {
     daysTemp = daysTemp - 29;
     months++;
  } else if (months == 2 && isLeapYear == false && (daysTemp - 28 > 0)) {
     daysTemp = daysTemp - 28;
     months++;
  } else if ((months == 4 && (daysTemp - 30 > 0)) || (months == 6 && (daysTemp - 30 > 0)) || (months == 9 && (daysTemp - 30 > 0)) || (months == 11 && (daysTemp - 30 > 0))) {
     daysTemp = daysTemp - 30;
     months++;
  } else {
     counter--;
  }
}

if (months == 1) {
   month = "January";
} else if (months == 2) {
   month = "Febuary";
} else if (months == 3) {
   month = "March";
} else if (months == 4) {
   month = "April";
} else if (months == 5) {
   month = "May";
} else if (months == 6) {
   month = "June";
} else if (months == 7) {
   month = "July";
} else if (months == 8) {
   month = "August";
} else if (months == 9) {
   month = "September";
} else if (months == 10){
   month = "October";
} else if (months == 11){
   month = "November";
} else {
   month = "December";
}
day = daysTemp;


System.out.println("FANCY CLOCK BETA");
System.out.println("Current date: " + month + " " + day + ", " + year);


}
}