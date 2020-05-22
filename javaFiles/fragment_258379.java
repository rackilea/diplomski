int hour = 0;
int minute = 0;

for(<your row loop>) {
    String[] rowtime= row[i].split(":");
    hour += Integer.parseInt(rowtime[0]);
    minute += Integer.parseInt(rowtime[1]);
}

hour += minute / 60;
minute %= 60;

String result = hour + ":" + minute