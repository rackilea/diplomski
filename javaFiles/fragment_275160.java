try {
    Scanner s = new Scanner(System.in);
    System.out.println("Please enter your birthday. Format: DD.MM.YYYY");
    String bday = s.nextLine();

    Date date = new SimpleDateFormat("dd.MM.yyyy").parse(bday);

    Calendar birthday = Calendar.getInstance();
    birthday.setTime(date);
    String weekday = birthday.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    System.out.println("Weekday of birth: " + weekday); // wrong    }
} catch (ParseException exp) {
    exp.printStackTrace();
}