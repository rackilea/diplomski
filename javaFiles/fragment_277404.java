@Test
    public void testDateFormat() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date myDate = df.parse("2011/11/11 11:11:11");
        System.out.println(df.format(myDate));
    }