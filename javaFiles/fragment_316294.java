try {
    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(x);
} catch (Exception e) {
    e.printStackTrace();
}

series.appendData(new DataPoint(date1, z), true, 25);