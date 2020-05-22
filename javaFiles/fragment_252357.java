List<Plan> plans = new ArrayList<>();
    plans.add(new Plan("10683", "163", "213"));
    plans.add(new Plan("10683", "616", "194"));
    plans.add(new Plan("10683", "163", "212"));
    plans.add(new Plan("10683", "163", "211"));
    plans.add(new Plan("10683", "163", "214"));

    System.out.println(
        plans.stream().collect(
               Collectors.groupingBy(p -> p.id + " " + p.aCode, 
               Collectors.mapping(Plan::getCompartment, Collectors.joining("/")))));