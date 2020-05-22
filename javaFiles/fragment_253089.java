DecimalFormat df = new DecimalFormat("#");
df.setMaximumFractionDigits(8);

String dateString = df.format(val);

if(dateString.startsWith(".")) {
    dateString = "0" + dateString;
}

Duration.parse("PT" + dateString + "s");