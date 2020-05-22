public static String getAge(int year, int month, int day) {
    Calendar dob = Calendar.getInstance();
    Calendar today = Calendar.getInstance();


    dob.set(year, month - 1, day);

    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
    if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
        age--;
    } else if(today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)) {
        if (today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
    }

    Integer ageInt = new Integer(age);
    String ageS = ageInt.toString();

    return ageS;

}