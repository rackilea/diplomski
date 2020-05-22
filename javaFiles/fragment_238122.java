String[] points = {"100", "500", "200", "400", "300"};
String[] countries = {"nepal", "japan", "finland", "brazil", "spain"};
CustomArrayComparator comparator = new CustomArrayComparator(points, countries);
Arrays.sort(countries, comparator);
Arrays.sort(points, Collections.reverseOrder());

System.out.println(Arrays.toString(points));
System.out.println(Arrays.toString(countries));