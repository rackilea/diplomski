String [] predefinedCities = res.getStringArray(R.array.predefined_cities);

    prefs = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
    Iterator<String> userCities = readCitiesFromPref(); // unsorted values

    List<String> copyOfCities = new ArrayList<String>();
    while (userCities.hasNext()){

        copyOfCities.add(userCities.next());

    }

    ArrayList<String> sortedCities = new ArrayList<String>();
    sortedCities.addAll(copyOfCities);
    sortedCities.addAll(Arrays.asList(predefinedCities));
    Collections.sort(sortedCities);

    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sortedCities);