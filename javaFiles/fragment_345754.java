public static void main(String[] args) {
    String time1 = "8:00";
    String time2 = "9:00";
    int t1 = getTotalMinutes(time1);
    int t2 = getTotalMinutes(time2);
    int total = t1 + t2;
    String result = getResult(total);
    System.out.println(result);
}

public static int getTotalMinutes(String time) {
    String[] t = time.split(":");
    return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
}

public static String getResult(int total) {
    int minutes = total % 60;
    int hours = ((total - minutes) / 60) % 24;
    return String.format("%02d:%02d", hours, minutes);
}