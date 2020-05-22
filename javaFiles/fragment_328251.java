String time = "3:30 PM";

    SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");

    SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

    System.out.println(date24Format.format(date12Format.parse(time)));