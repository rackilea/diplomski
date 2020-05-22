List<String> results = Arrays.asList("ABCD XYZ M1210", "ABCD XYZ M149",
        "ABCD XYZ M5130", "ABCD XYZ N1420", "ABCD XYZ T11299",
        "ABCD XYZ S11044");

        Collections.sort(results, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                Integer x1 = Integer.parseInt(o1.substring(o1.lastIndexOf(" ")+2, o1.length()));
                Integer x2 = Integer.parseInt(o2.substring(o2.lastIndexOf(" ")+2, o2.length()));

                return x1.compareTo(x2);

            }
        });

        System.out.println(results);