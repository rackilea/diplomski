private void selectDate(String Departdate, String Departmonth, String Departyear) {
        //div[@id='PegasusCal-0']//a[@id='a_2017_3_13']
        String dateXpath = String.format(
                "//div[@id='PegasusCal-0']//a[@id='a_%s_%d_%s']",
                Departyear, getMonthNum(Departmonth), Departdate);
        driver.findElement(By.xpath(dateXpath)).click();
    }

     //As you are passing input in name 'October' parsing that to number
    private int getMonthNum(String monthName) {
        try {
            Date date = new SimpleDateFormat("MMM").parse(monthName);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.MONTH) + 1;
        } catch (ParseException ex) {
            Logger.getLogger(Yatra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }