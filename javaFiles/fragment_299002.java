int time1 =  350;
int time2 = 1210;
//
int hour1 = time1 / 100;
int hour2 = time2 / 100;
int comparationResult = Integer.compare(hour1, hour2);
if (comparationResult == 0) {
    int min1 = time1 % 100;
    int min2 = time2 % 100;
    comparationResult = Integer.compare(min1, min2);
}