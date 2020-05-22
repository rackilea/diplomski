SimpleDateFormat inputFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z",
                                                    Locale.US);
DateFormat outputFormat = DateFormat.getDateInstance(DateFormat.LONG,
                                                     userLocale);
// TODO: Set time zone in outputFormat

Date date = inputFormat.parse(inputText);
String outputText = outputFormat.format(date);