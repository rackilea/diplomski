double waittime = 100;
int index = 0;
NumberFormat nf = NumberFormat.getNumberInstance();
nf.setMinimumFractionDigits(1000);
while (true) {
    index++;
    System.out.println(String.valueOf(index) + "\t" + (waittime / 1000) + "; " + nf.format(waittime) + " seconds");
    waittime = waittime / 2;
    if (waittime <= 0) {
        break;
    }
    try {
        Thread.sleep((long) waittime);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}