Calendar c = Calendar.getInstance();
int numConsecutive = 0;
Date last = null;

for (int i = 0; i < dates.length; i++) {
    c.setTime(dates[i]);
    c.add(Calendar.DATE, -1);
    if (c.getTime().equals(last)) {
        numConsecutive++;
    } else {
        numConsecutive = 0;
    }
    if (numConsecutive == 2) {
        numConsecutive = 0;
        count++;
    }
    last = dates[i];
}