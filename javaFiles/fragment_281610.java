for (String s: list) {
    System.out.println(s);
    if (!isReassigned) {
        new Thread(() -> reassignList()).start();
        isReassigned = true;
    } else {
        System.out.println("Latest data " + list);
    }
    Thread.sleep(1000);
 }