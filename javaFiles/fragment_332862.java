Date value = new Date();
System.out.printf("Before %s%n", value);
Calendar calendar = Calendar.getInstance();
calendar.setTime(value);
System.out.printf(
    "After %s%n", 
    new Date(
        calendar.get(Calendar.YEAR) - 1900, 
        calendar.get(Calendar.MONTH), 
        calendar.get(Calendar.DAY_OF_MONTH)
    )
);