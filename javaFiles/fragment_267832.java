SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

Date date1 = format1.parse(value1);
Date date2 = format2.parse(value2);

return date1.equals(date2);