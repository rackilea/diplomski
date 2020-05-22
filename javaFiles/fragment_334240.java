String testDate = "11 Ноя 1980 г.";
    String[] months = {"Янв", "Фев", "Мар", "Апр", "Мая", "Июн", "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек"};
    Locale ru = new Locale("ru");
    DateFormatSymbols symbols = DateFormatSymbols.getInstance(ru);
    symbols.setMonths(months);
    SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy 'г.'", ru);
    format.setDateFormatSymbols(symbols);
    try {
        Log.d(TAG, "Date is: " + format.parse(testDate));
    } catch (Exception e) {
        Log.e(TAG, "Error while parsing", e);
    }