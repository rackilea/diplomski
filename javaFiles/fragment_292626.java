if (now.isBefore(startTime)) {
    Duration d = Duration.between(now, startTime);
    System.out.println("Event starting in about " + d);
}
else if (now.isBefore(endTime)) {
    System.out.println("Event is now going on");
}
else {
    System.out.println("Event has passed");
}