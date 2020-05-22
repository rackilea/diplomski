List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");

        list2.add("d");
        list2.add("e");
        list2.add("f");

        String aux = list1.set(0, list2.get(2));

        System.out.println(list1);
        System.out.println(aux); // aux is a now