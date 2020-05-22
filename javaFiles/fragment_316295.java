try {
    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(x);
    series.appendData(new DataPoint(date1, z), true, 25);
} catch (Exception e) {
    e.printStackTrace();
}