List<XXX> items = list2.stream()
            .map(itemL1->{
                        return list1.stream().
                            filter((itemL2)->itemL2.getId().equals(itemL1.getId()))
                            .collect(Collectors.toList());
                    }
                )
            .flatMap(List::stream)
            .collect(Collectors.toList());