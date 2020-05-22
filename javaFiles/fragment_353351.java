public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the first time: ");
    String time1 = s.next();
    System.out.print("Enter the second time: ");
    String time2 = s.next();
    String tm1 = String.format("%02d", Integer.parseInt(time1));
    String tm2 = String.format("%02d", Integer.parseInt(time2));

    String hrs1 = time1.substring(0, 2);
    String min1 = time1.substring(2, 4);
    String hrs2 = time2.substring(0, 2);
    String min2 = time2.substring(2, 4);

    // int difference = t2 - t1;
    if (Integer.parseInt(time1) < Integer.parseInt(time2)) {
        int minDiff = Integer.parseInt(min2) - Integer.parseInt(min1);
        int hrsDiff = Integer.parseInt(hrs2) - Integer.parseInt(hrs1);
        if (minDiff < 0) {
            minDiff += 60;
            hrsDiff--;
        }

        System.out.println("The difference between times is " + hrsDiff + " hours " + minDiff + " minutes.");

    } else {
        int minDiff = Integer.parseInt(min1) - Integer.parseInt(min2);
        int hrsDiff = Integer.parseInt(hrs1) - Integer.parseInt(hrs2);
        if (minDiff < 0) {
            minDiff += 60;
            hrsDiff--;
        }

        System.out.println("The difference between times is " + hrsDiff + " hours " + minDiff + " minutes.");

    }

}