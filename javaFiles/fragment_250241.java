List<String> contain = new ArrayList<String>();
    contain.add("HPDH-1,001, Check-out date: 7/7/7");
    contain.add("JTI-1,001, Check-out date: 7/7/7");
    String code = "JTI-1 ";
    for (int i = 0; i < contain.size(); i++) {
        if (contain.get(i).contains(code.trim())) {<---Use trim it is possible that code may have extra space
            System.out.println(contain.get(i));
        }
    }