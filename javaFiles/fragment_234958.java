int lastRiid = 0;

for (int i = 0; i < array.length; i++) {
    if (array[i][0] != lastRiid) {
        lastRiid = array[i][0];
        System.out.println(lastRiid);
    }
}