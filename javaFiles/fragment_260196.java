String line = "Name, Show starts on 14/08/09, your ticket is booked on 14/08/09";
    String[] parts = line.split("[ ,]"); // ie split on comma or space

    String name = parts[0];
    String showDate = parts[5];
    String bookDate = parts[12];

    System.out.println(name + ":" + showDate + ":" + bookDate);