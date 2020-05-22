Calendar c1 = Calendar.getInstance();
c1.set(2013, 1, 1);

Calendar c2 = Calendar.getInstance();
c2.set(2014, 11, 1);

while (!c1.after(c2)) {
    System.out.println(c1.getTime());

    c1.add(Calendar.DAY_OF_YEAR, 1);
}