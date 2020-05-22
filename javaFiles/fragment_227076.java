...

preferences = new ArrayList<List<String>>();
preferences1 = new ArrayList<String>();
preferences2 = new ArrayList<String>();

// add second student
preferences1.add("Company5"); preferences1.add("Company7");
preferences2.add("Company6"); preferences2.add("Company8");
preferences.add(preferences1); preferences.add(preferences2);
students.add(new Student("William", preferences));