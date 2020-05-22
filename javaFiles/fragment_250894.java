List<A> objects = new ArrayList<>();

        A A1 = new A(111, 10, "333");
        A A2 = new A(222, 20, "333");
        A A22 = new A(222, 20, "333");
        A A3 = new A(333, 2, "444");
        A A4 = new A(444, 5, "444");
        A A5 = new A(666, 6, "777");

        objects.add(A1);
        objects.add(A2);
        objects.add(A22);
        objects.add(A3);
        objects.add(A4);
        objects.add(A5);


        List<A> output = objects
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(A::getX3, a -> {
                            a.getList().add(a.getX1());
                            return a;
                        }, (a, b) -> {
                            a.getList().addAll(b.getList());
                            a.setX2(a.getX2() + b.getX2());
                            return a;
                        }),
                        map -> new ArrayList(map.values())
                ));

        System.out.println(output);