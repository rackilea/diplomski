List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person(Integer.toString(i), Integer.toString(i), i);
            list.add(p);
        }
        Collections.shuffle(list);
        System.out.println("the shuffled list");
        list.forEach(i -> System.out.println(i.toString() + " "));
        Collections.sort(list, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        System.out.println("------------------------ \n the orderd list");
        list.forEach(i -> System.out.println(i.toString() + " "));