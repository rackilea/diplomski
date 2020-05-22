SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                                                    Locale.US);
// TODO: Set the time zone appropriately
Date date = inputFormat.parse(inputText);

SimpleDateFormat outputFormat = new SimpleDateFormat("d MMM", targetLocale);
// TODO: Set the time zone appropriately
String outputText = outputFormat.format(date);