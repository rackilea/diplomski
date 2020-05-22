String[] timesSplit = times.split(" | ");

int hour = 0;
int minute = 0;

for(int i = 0; i < timesSplit.length; i += 2) {
    String[] time = timesSplit[i].split(":");
    hour += Integer.parseInt(time[0]);
    minute += Integer.parseInt(time[1]);
}

hour += minute / 60;
minute %= 60;

String result = hour + ":" + minute;