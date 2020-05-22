List<String> list = new ArrayList<String>();
        list.add("Test");
        list.add("Test Test");
        list.add("Test Second");
        String queryString = "Te*s";
//      queryString = queryString.replaceAll("\\*", "\\.\\*");
        queryString = queryString.concat(".*");
        for (String str : list) {
                if (str.matches(queryString))
                    System.out.println(str);
        }