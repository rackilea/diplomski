ArrayList<Double> list = new ArrayList();
list.add(parseDouble("7.01"));
list.add(parseDouble("12.01"));
list.add(parseDouble("9.00"));
list.add(parseDouble("8.1"));

//System.out.println(Collections.min(list));

int indexOfMinimum = list.indexOf(Collections.min(list));