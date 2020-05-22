long endTime = 1378140843604L; // for example
for (long now = 0; now < endTime; i++) {
    now = System.currentTimeMillis(); // will be 1378140783604, 1378140784604, 1378140785604 and so on
    System.out.println("now" + now); 
    System.out.println("end" + endTime);
    Thread.sleep(1000L);
}