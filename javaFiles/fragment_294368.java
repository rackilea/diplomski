Calendar deadline = Calendar.getInstance();
deadline.set(2011,6,21,11,20,00);
long endTime = deadline.getTime().getTime();

// later
long current = System.currentTimeMillis();
if (current >= endTime) {
    System.out.println("Got it!");
    break;
}