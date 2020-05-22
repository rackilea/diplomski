String[] foodNames = context.getResources().getStringArray(R.array.food_names);
String[] foodDescriptions = context.getResources().getStringArray(R.array.food_descriptions);

static final String FOOD_FORMAT = "%s :: $s";
for (int i=0; i<foodNames.length; i++) {
    System.out.println(
            String.format(FOOD_FORMAT,
                          foodNames[i],
                          foodDescriptions[i]
            )
    );
}