SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z",
                                                    Locale.US);
Date date = inputFormat.parse(inputText);

// Potentially use the default locale. This will use the local time zone already.
SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm", Locale.US);
String outputText = outputFormat.format(date);