// group by first value
Map<Integer, Record> newList = list.stream().collect(Collectors.groupingBy(Record::getFirstValue,
       // for each record list for the same first value, add the second one          
       Collectors.collectingAndThen(
            // add first and second value for each pair
            Collectors.reducing((r1, r2) -> new Record(r1.getFirstValue(), r1.getSecondValue() + r2.getSecondValue())),
            // there will be no empty list, so all optionals will be present
            Optional::get));