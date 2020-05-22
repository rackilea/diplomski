Complex[] time1Dummy = new Complex[time1.size()];
Complex[] freq1 = new Complex[time1.size()];
System.out.println("Size of time1:" +time1.size());

for(int i = 0; i < time1.size(); i++) {
    time1Dummy[i] = new Complex();
    time1Dummy[i].setRe(time1.get(i));
    time1Dummy[i].setIm(0.00);
}