String finalDate = day + " " + month + " " + year; 

SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

Calendar c = Calendar.getInstance();

try {
    c.setTime(sdf.parse(finalDate));
} catch (ParseException e) {
    e.printStackTrace();
}

int addDays = Integer.parseInt(editText2.getText().toString());

c.add(Calendar.DATE, addDays);  // number of days to add
SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy");
String output = sdf1.format(c.getTime());