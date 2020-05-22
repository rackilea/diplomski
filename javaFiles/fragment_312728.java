String time1 = "10:45";
String time2 = "02:30";

String[] split1 = time1.split(":");
String[] split2 = time2.split(":");

int total = 60 * Integer.parseInt(split1[0]) +
            Integer.parseInt(split1[1]) +
            60 * Integer.parseInt(split2[0]) +
            Integer.parseInt(split2[1]);

int hours = total / 60;
int minutes = total - hours * 60;
System.out.println(hours + ":" + minutes);