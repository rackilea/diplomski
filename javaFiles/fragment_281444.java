int count = 2;
        List<Double> lst = new ArrayList<>();
        lst.add(1.3);
        lst.add(14.2);
        lst.add(15.6);
        System.out.println(lst);

        List<Double> newlst = count<lst.size()?lst.subList(count, lst.size()):new ArrayList<Double>();
        System.out.println(newlst);